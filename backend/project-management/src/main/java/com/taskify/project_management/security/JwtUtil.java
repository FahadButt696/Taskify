package com.taskify.project_management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.security.Key;

@Component
public class JwtUtil {

    @Value("${jwt.secretKey}")
    private String SECRET_KEY ;

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

    public <T> T getClaim(Claims claims, String claimName, Class<T> type, T defaultValue) {
        return claims.containsKey(claimName) ? claims.get(claimName, type) : defaultValue;
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
