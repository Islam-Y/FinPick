package ru.finpick.admin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Сущность пользователя (делимповая копия из user-service для админки).
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    /** PK — автогенерируемый идентификатор */
    @Id
    private Long id;

    /** Логин пользователя */
    private String username;

    /** Электронная почта */
    private String email;

    /** Роль пользователя */
    private String role;
}