package ru.finpick.admin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO для запроса на изменение роли пользователя.
 */
@Getter
@Setter
public class UserRoleUpdateRequest {

    /** Идентификатор пользователя */
    private Long userId;

    /** Новая роль для пользователя */
    private String newRole;
}