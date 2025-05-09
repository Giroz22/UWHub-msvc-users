package com.waveghost.msvc_users_security.infrastructure.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.generator}")
    private String userGenerator;

    public String createToken(Authentication authentication){

        //Algorithm that will encrypt the token
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

        //Info of the user
        String username = authentication.getPrincipal().toString();
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //Creation of token
        String jwtToken = JWT.create()
                //Only backend know what is this user
                .withIssuer(userGenerator)

                //User owner of token
                .withSubject(username)

                //Claims of the payload
                .withClaim("authorities", authorities)

                //Date when the token was created
                .withIssuedAt(new Date())

                //Date when token expired
                .withExpiresAt(new Date(System.currentTimeMillis() + 1800000))

                //Random ID the token
                .withJWTId(UUID.randomUUID().toString())

                //Date when the token can be utilized
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);

        return jwtToken;
    }

    public DecodedJWT validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);

            return decodedJWT;

        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Token invalid, not authorized");
        }
    }

    public String extractUserName(DecodedJWT decodedJWT){
        return decodedJWT.getSubject();
    }

    public Claim getSpecificClaim(DecodedJWT decodedJWT, String claimsName){
        return decodedJWT.getClaim(claimsName);
    }

    public Map<String, Claim> getAllClaims(DecodedJWT decodedJWT){
        return decodedJWT.getClaims();
    }
}
