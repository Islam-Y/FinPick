package ru.finpick.analytics.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * DTO-ответ с агрегированной статистикой.
 */
@Getter
@Setter
public class AnalyticsStatsResponse {

    /** Общее количество событий по типу */
    private Map<String, Long> countByType;

    /** Общее количество событий по пользователям */
    private Map<Long, Long> countByUser;
}