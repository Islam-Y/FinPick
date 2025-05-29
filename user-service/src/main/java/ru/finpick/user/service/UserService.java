package ru.finpick.user.service;

import ru.finpick.user.dto.AuthResponse;
import ru.finpick.user.dto.LoginRequest;
import ru.finpick.user.dto.RegisterRequest;
import ru.finpick.user.dto.UserProfileResponse;

/**
 * Интерфейс бизнес-логики для управления пользователями.
 */
public interface UserService {

    /**
     * Регистрирует нового пользователя, возвращает его профиль.
     */
    UserProfileResponse register(RegisterRequest request);

    /**
     * Аутентифицирует пользователя и выдаёт JWT-токен.
     */
    AuthResponse authenticate(LoginRequest request);

    /**
     * Возвращает профиль текущего пользователя.
     */
    UserProfileResponse getProfile(String username);
}
