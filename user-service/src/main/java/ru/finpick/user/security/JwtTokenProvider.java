package ru.finpick.user.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import io.jsonwebtoken.security.Keys;

import java.security.Key;

/**
 * Утилита для создания, валидации и парсинга JWT-токенов.
 */
@Component
public class JwtTokenProvider {

    /** Секретный ключ для подписи токенов (должен быть не короче 256 бит) */
    @Value("${jwt.secret}")
    private String secretKey;

    /** Время жизни токена в миллисекундах */
    @Value("${jwt.expiration-ms}")
    private long validityInMs;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    /**
     * Создаёт JWT-токен с subject=username.
     */
    public String createToken(String username) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + validityInMs);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Проверяет корректность подписи и срок жизни токена.
     *
     * @param token JWT-токен без префикса "Bearer "
     * @return true, если токен валиден
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // некорректный токен (искажённый, просроченный и т.п.)
            return false;
        }
    }

    /**
     * Извлекает имя пользователя (subject) из токена.
     *
     * @param token JWT-токен без префикса "Bearer "
     * @return username из поля subject
     */
    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
