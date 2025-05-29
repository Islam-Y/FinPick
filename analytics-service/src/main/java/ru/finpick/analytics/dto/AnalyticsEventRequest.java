package ru.finpick.analytics.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-запрос на сохранение события аналитики.
 */
@Getter
@Setter
public class AnalyticsEventRequest {

    /**
     * Тип события (например, PAYMENT, LOGIN).
     */
    public String type;

    /**
     * Идентификатор пользователя.
     */
    public Long userId;

    /**
     * Дополнительные данные (JSON).
     */
    public String payload;
}