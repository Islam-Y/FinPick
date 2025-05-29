package ru.finpick.analytics.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность, представляющая одно аналитическое событие.
 */
@Entity
@Getter
@Setter
@Table(name = "analytics_event")
public class AnalyticsEvent {

    /** PK — автогенерируемый идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Тип события */
    private String type;

    /** Идентификатор пользователя */
    private Long userId;

    /** Время сохранения события */
    private LocalDateTime timestamp;

    /** Произвольная полезная нагрузка */
    @Column(length = 2000)
    private String payload;
}
