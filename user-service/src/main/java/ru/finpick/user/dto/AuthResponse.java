package ru.finpick.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO-ответ при успешной аутентификации.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    /** JWT-токен для доступа к защищённым ресурсам */
    private String accessToken;

    /** Тип токена, например, "Bearer" */
    private String tokenType = "Bearer";
}
