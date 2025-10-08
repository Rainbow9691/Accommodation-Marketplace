package com.dcl.accommodate.security.jwt;

import com.dcl.accommodate.config.AppEnv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private Key key;
    public JwtService(AppEnv env){
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(env.getJwt().getSecret()));
    }
    public String generateToken(Map<String,Object> claims, String subject, Duration ttl){
        var systemMill = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(systemMill))
                .setExpiration(new Date(systemMill+ttl.toMillis()))
                .setSubject(subject)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    private Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}