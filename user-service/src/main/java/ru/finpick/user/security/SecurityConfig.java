package ru.finpick.user.security;

import ru.finpick.user.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Настройки безопасности для user-service на Spring Security 6.
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;

    /**
     * Кодировщик паролей.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Основная цепочка фильтров безопасности.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Отключаем CSRF (т.к. у нас stateless API)
                .csrf(csrf -> csrf.disable())
                // Указываем, что сессий не будет, всё по JWT
                .sessionManagement(sm -> sm
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // Разрешаем всем доступ к регистраци и логину, остальные — по токену
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/register", "/api/v1/users/login").permitAll()
                        .anyRequest().authenticated()
                )
                // Вставляем наш JWT-фильтр до UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtAuthFilter,
                        org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                // Оставляем дефолтные обработчики ошибок
                .exceptionHandling(Customizer.withDefaults());

        return http.build();
    }
}