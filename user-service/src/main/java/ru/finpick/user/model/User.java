package ru.finpick.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность пользователя.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /** PK — автогенерируемый идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Логин (уникальный) */
    @Column(unique = true, nullable = false)
    private String username;

    /** Хеш пароля */
    @Column(nullable = false)
    private String password;

    /** Электронная почта */
    @Column(unique = true, nullable = false)
    private String email;

    /** Дата регистрации */
    private LocalDateTime createdAt;

    // @PrePersist для createdAt
}
