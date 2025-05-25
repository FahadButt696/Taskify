package com.taskify.user_management.security;

import com.taskify.user_management.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secretKey}")
    private String SECRET_KEY ;

    @Value("${jwt.ExpirationMillis}")
    private long jwtExpirationInMillis ;

        public String generateToken(User userDetails){
            return generateToken(new HashMap<>(), userDetails);
        }
        public String generateToken(Map<String,Object> claims, User userDetails){
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMillis ))
                    .signWith(getSingingKey(), SignatureAlgorithm.HS256)
                    .compact();
        }

    public <T> Claims validateToken(String token, T validationData) {
        Claims data= extractAllClaims(token);
        Class<?> clazz = validationData.getClass();

        try {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object fieldValue = field.get(validationData);

                if (data.containsKey(fieldName)) {
                    Object actualValue = data.get(fieldName);
                    if (!String.valueOf(actualValue).equals(String.valueOf(fieldValue))) {
                        throw new RuntimeException(fieldName + " is incorrect");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Validation Failed");
        }

        return data;
    }

        public boolean isTokenValid(String token, UserDetails userDetails){
            Claims claims = validateToken(token,userDetails);
            return (!isTokenExpired(token) && claims!=null);
        }

        public boolean isTokenExpired(String token) {
            return tokenExpirationDate(token).before(new Date());
        }

        public Date tokenExpirationDate(String token) {
            return extractClaim(token, Claims::getExpiration);
        }

        public String extractUserEmail(String token) {
            return extractClaim(token,Claims::getSubject);
        }

        public <T>T  extractClaim(String token, Function<Claims,T> claimsResolver) {
            Claims claims=extractAllClaims(token);
            return claimsResolver.apply(claims);
        }

        public Claims extractAllClaims(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(getSingingKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }
        private Key getSingingKey() {
            byte[] key= Decoders.BASE64.decode(SECRET_KEY);
            return Keys.hmacShaKeyFor(key);
        }

}
