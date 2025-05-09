package com.waveghost.msvc_users_security.infrastructure.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.waveghost.msvc_users_security.infrastructure.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
public class JwtTokenValidator extends OncePerRequestFilter {

    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException
    {
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        //If user don´t send a token continue with other filter
        if (jwtToken != null){
            //Extract token of 'Bearer token...'
            jwtToken = jwtToken.substring(7);

            //Validate if token is valid
            DecodedJWT decodedJWT = jwtUtils.validateToken(jwtToken);

            //If token is valid extract info (username and authorities)
            String username = jwtUtils.extractUserName(decodedJWT);
            String stringAuthorities = jwtUtils.getSpecificClaim(decodedJWT ,"authorities").asString();
            //Convert authorities string to GrantedAuthorities
            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);

            //We create the context where it will save the user
            SecurityContext context = SecurityContextHolder.getContext();
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
        }

        filterChain.doFilter(request,response);
    }
}
