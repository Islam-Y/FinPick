package ru.finpick.user.security.jwt;

import ru.finpick.user.security.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Фильтр, который для каждого запроса:
 * 1. Извлекает JWT из заголовка Authorization
 * 2. Валидирует токен через JwtTokenProvider
 * 3. Если валидно — создаёт Authentication и помещает его в SecurityContext
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /** Провайдер для работы с JWT: создание и валидация */
    private final JwtTokenProvider tokenProvider;
    /** Сервис для загрузки деталей пользователя по username */
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider,
                                   UserDetailsService userDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        // Извлекаем токен из заголовка, если он есть
        String header = request.getHeader("Authorization");
        String token = null;
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);
        }

        // Если токен присутствует и валидный — аутентифицируем пользователя
        if (token != null && tokenProvider.validateToken(token)) {
            String username = tokenProvider.getUsername(token);
            // Загружаем детали пользователя из БД/сервиса
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            // Создаём объект аутентификации
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // Сохраняем в контекст
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // Передаём управление дальше по фильтровой цепочке
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) {
        // Не применять фильтр к публичным эндпоинтам регистрации и логина
        String path = request.getServletPath();
        return path.equals("/api/v1/users/register") ||
                path.equals("/api/v1/users/login");
    }
}
