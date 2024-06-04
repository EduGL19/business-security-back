package com.code.BusinessSecurity.domain.ports.in;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTServiceIn {

    String extractUsernameIn(String token);
    String generateTokenIn(UserDetails userDetails);
    boolean validateTokenIn(String token, UserDetails userDetails);
    String generateRefreshTokenIn(Map<String, Object> extraClaims, UserDetails userDetails);

}
