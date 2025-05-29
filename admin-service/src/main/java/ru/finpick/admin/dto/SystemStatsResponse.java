package ru.finpick.admin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO для передачи системных метрик и статистики.
 */
@Getter
@Setter
public class SystemStatsResponse {

    /** Общее число зарегистрированных пользователей */
    private long totalUsers;

    /** Число событий аналитики за сегодня */
    private long todayAnalyticsEvents;

    /** Число платежей за сегодня */
    private long todayPayments;
}
