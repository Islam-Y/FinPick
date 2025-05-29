package ru.finpick.admin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO для передачи информации о пользователе в UI админа.
 */
@Getter
@Setter
public class UserProfileResponse {

    /** Идентификатор пользователя */
    private Long id;

    /** Логин пользователя */
    private String username;

    /** Электронная почта */
    private String email;

    /** Текущая роль (например, USER, ADMIN) */
    private String role;
}
