package com.code.BusinessSecurity.Infraestructure.adapters;

import com.code.BusinessSecurity.domain.ports.out.JWTServiceOut;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTAdapter implements JWTServiceOut {

    @Value("${key.token}")
    private String keytoken;


    @Override
    public String extractUsernameOut(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public String generateTokenOut(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 120000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean validateTokenOut(String token, UserDetails userDetails) {
        final String username = extractUsernameOut(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @Override
    public String generateRefreshTokenOut(Map<String, Object> extraClaims, UserDetails userDetails) {
        return null;
    }





    /*
    @Override
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public String generateTokenOut(UserEntity userEntity) {
        return Jwts.builder().setSubject(userEntity.getFirstName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 120000))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean validateToken(String token, UserEntity userEntity) {
        final String username = extractUsername(token);
        return (username.equals(userEntity.getFirstName()) && !isTokenExpired(token));
    }

    @Override
    public String generateRefreshToken(Map<String, Object> extraClaims, UserEntity userEntity) {
        return null;
    }
    */


    private Key getSignKey(){
        byte[] key = Decoders.BASE64.decode(keytoken);
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResult){
        final Claims claims = extractAllClaims(token);
        return claimsResult.apply(claims);
    }

    private boolean isTokenExpired(String token){
        return extractClaims(token,Claims::getExpiration).before(new Date());
    }


}
