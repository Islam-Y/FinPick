package ru.finpick.analytics.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-запрос на сохранение события аналитики.
 */
@Getter
@Setter
public class AnalyticsEventRequest {

    /** Тип события (например, "PAYMENT", "LOGIN" и т.д.) */
    private String type;

    /** Идентификатор пользователя, связанного с событием */
    private Long userId;

    /** Произвольная полезная нагрузка (JSON-строка или прочее) */
    private String payload;
}