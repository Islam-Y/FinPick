package ru.finpick.analytics.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Событие, зафиксированное в системе аналитики.
 */
@Entity
@Getter
@Setter
public class AnalyticsEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * Тип события (например, PAYMENT, LOGIN, NOTIFICATION_CLICK).
     */
    private String type;

    /**
     * Идентификатор пользователя, связанного с событием.
     */
    private Long userId;

    /**
     * Время события.
     */
    private LocalDateTime timestamp;

    /**
     * Дополнительные данные в виде строки (например, JSON).
     */
    @Column(length = 2000)
    private String payload;
}
