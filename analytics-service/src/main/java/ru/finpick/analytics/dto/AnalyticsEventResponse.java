package ru.finpick.analytics.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DTO-ответ с данными одного сохранённого события.
 */
@Getter
@Setter
public class AnalyticsEventResponse {

    /** Уникальный ID события */
    private Long id;

    /** Тип события */
    private String type;

    /** ID пользователя */
    private Long userId;

    /** Время регистрации события */
    private LocalDateTime timestamp;

    /** Полезная нагрузка события */
    private String payload;

}
