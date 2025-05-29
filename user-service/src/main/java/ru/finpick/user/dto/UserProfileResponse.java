package ru.finpick.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO для передачи данных профиля пользователя.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {

    /** Уникальный идентификатор пользователя */
    private Long id;

    /** Логин пользователя */
    private String username;

    /** Электронная почта */
    private String email;
}
