package ru.finpick.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO для аутентификации (входа) пользователя.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    /** Логин пользователя */
    @NotBlank
    private String username;

    /** Пароль пользователя */
    @NotBlank
    private String password;
}
