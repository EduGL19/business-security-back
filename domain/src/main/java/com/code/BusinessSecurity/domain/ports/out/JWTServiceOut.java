package com.code.BusinessSecurity.domain.ports.out;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTServiceOut {

    String extractUsernameOut(String token);
    String generateTokenOut(UserDetails userDetails);
    boolean validateTokenOut(String token, UserDetails userDetails);
    String generateRefreshTokenOut(Map<String, Object> extraClaims, UserDetails userDetails);

}
