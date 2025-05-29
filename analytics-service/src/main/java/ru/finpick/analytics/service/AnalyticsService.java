package ru.finpick.analytics.service;

import ru.finpick.analytics.dto.AnalyticsEventRequest;
import ru.finpick.analytics.dto.AnalyticsEventResponse;
import ru.finpick.analytics.dto.AnalyticsStatsResponse;
import java.util.List;

/**
 * Интерфейс сервисного слоя аналитики.
 */
public interface AnalyticsService {

    /**
     * Сохраняет входящее событие в базу.
     */
    AnalyticsEventResponse recordEvent(AnalyticsEventRequest request);

    /**
     * Возвращает все сохранённые события.
     */
    List<AnalyticsEventResponse> getAllEvents();

    /**
     * Собирает агрегированную статистику по событиям.
     */
    AnalyticsStatsResponse getStatistics();
}