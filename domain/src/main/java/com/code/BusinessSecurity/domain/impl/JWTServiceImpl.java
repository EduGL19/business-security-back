package com.code.BusinessSecurity.domain.impl;

import com.code.BusinessSecurity.domain.ports.in.JWTServiceIn;
import com.code.BusinessSecurity.domain.ports.out.JWTServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class JWTServiceImpl implements JWTServiceIn {

    private final JWTServiceOut jwtServiceOut;

    @Override
    public String extractUsernameIn(String token) {
        return jwtServiceOut.extractUsernameOut(token);
    }

    @Override
    public String generateTokenIn(UserDetails userDetails) {
        return jwtServiceOut.generateTokenOut(userDetails);
    }

    @Override
    public boolean validateTokenIn(String token, UserDetails userDetails) {
        return jwtServiceOut.validateTokenOut(token,userDetails);
    }

    @Override
    public String generateRefreshTokenIn(Map<String, Object> extraClaims, UserDetails userDetails) {
        return jwtServiceOut.generateRefreshTokenOut(extraClaims,userDetails);
    }
}
