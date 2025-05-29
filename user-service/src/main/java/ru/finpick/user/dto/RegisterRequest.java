package ru.finpick.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO для регистрации нового пользователя.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    /** Логин пользователя, используемый в качестве username */
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    /** Пароль пользователя (будет захеширован) */
    @NotBlank
    @Size(min = 6)
    private String password;

    /** Электронная почта пользователя */
    @NotBlank
    @Email
    private String email;
}
