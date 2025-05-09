package com.waveghost.msvc_users_security.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.waveghost.msvc_users_security.infrastructure.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.waveghost.msvc_users_security.infrastructure.enums.UserRole;
import com.waveghost.msvc_users_security.infrastructure.exceptions.EmailAlreadyExistExeption;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.LoginRequest;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.request.RegisterRequest;
import com.waveghost.msvc_users_security.domain.model.RoleModel;
import com.waveghost.msvc_users_security.domain.model.UserModel;
import com.waveghost.msvc_users_security.domain.port.input.AuthServicePort;
import com.waveghost.msvc_users_security.domain.port.output.RolePersistencePort;
import com.waveghost.msvc_users_security.domain.port.output.UserPersistencePort;

@Service
public class AuthService implements AuthServicePort{

    @Autowired
    private PasswordEncoder passwordAuthentication;

    @Autowired
    private UserPersistencePort userPersistense;

    @Autowired
    private RolePersistencePort rolePersistense;

    @Autowired
    private JwtUtils jwtUtils;

    AuthService(PasswordEncoder passwordAuthentication) {
        this.passwordAuthentication = passwordAuthentication;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = this.userPersistense.findByEmailOrNickname(username);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        userModel.getRoles().stream().forEach(
            role -> authorities.add(
                        new SimpleGrantedAuthority("ROLE_".concat(role.getUserRole().name()))
                    )
        );

        UserDetails userDetails = User.builder()
            .username(userModel.getEmail())
            .password(userModel.getPassword())
            .authorities(authorities)
            .build();

        return userDetails;
    }

    public String login(LoginRequest request){
        String username = request.getUsername();
        String password = request.getPassword();
         
        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accesToken = jwtUtils.createToken(authentication);

        return accesToken;
    }

    public String register(RegisterRequest request){

        String username = request.getEmail();
        String password = request.getPassword();

        boolean userExist = this.userPersistense.existByEmailOrNickname(username);

        if(userExist)
            throw new EmailAlreadyExistExeption();

        //Volver findByUserRole que consulte el rol una vez en vez de cada vez que se necesite en base a un set final
        RoleModel roleModel = this.rolePersistense.findByUserRole(UserRole.USER);
        UserModel newUser = UserModel.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(this.passwordAuthentication.encode(password))
            .roles(Set.of(roleModel))
            .build();

        UserModel userSaved = this.userPersistense.create(newUser);

        //jwt
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userSaved.getRoles().forEach(role->
            authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getUserRole().name())))
        );

        Authentication authentication = new UsernamePasswordAuthenticationToken(
            username,
            null,
            authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
         
        String accesToken = jwtUtils.createToken(authentication);

        return accesToken;
    }

    public Authentication authenticate(String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);

        if (!this.passwordAuthentication.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (!this.passwordAuthentication.matches(oldPassword, userDetails.getPassword())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        String newPasswordEncode = this.passwordAuthentication.encode(newPassword);

        this.userPersistense.updatePassword(username, newPasswordEncode);
    }
}
