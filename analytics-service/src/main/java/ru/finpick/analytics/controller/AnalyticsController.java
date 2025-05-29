package ru.finpick.analytics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.finpick.analytics.dto.AnalyticsEventRequest;
import ru.finpick.analytics.dto.AnalyticsEventResponse;
import ru.finpick.analytics.dto.AnalyticsStatsResponse;
import ru.finpick.analytics.service.AnalyticsService;

import java.util.List;

/**
 * REST-контроллер для работы с аналитическими событиями и статистикой.
 */
@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    /**
     * Записывает новое аналитическое событие.
     *
     * @param request DTO с типом события, id пользователя и дополнительной нагрузкой
     * @return DTO сохранённого события с id и timestamp
     */
    @PostMapping("/events")
    public ResponseEntity<AnalyticsEventResponse> addEvent(
            @RequestBody AnalyticsEventRequest request) {
        AnalyticsEventResponse response = service.recordEvent(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Возвращает все сохранённые аналитические события.
     *
     * @return список DTO событий
     */
    @GetMapping("/events")
    public ResponseEntity<List<AnalyticsEventResponse>> getEvents() {
        List<AnalyticsEventResponse> list = service.getAllEvents();
        return ResponseEntity.ok(list);
    }

    /**
     * Возвращает агрегированную статистику по событиям:
     * количество по типам и количество по пользователям.
     *
     * @return DTO со статистикой
     */
    @GetMapping("/stats")
    public ResponseEntity<AnalyticsStatsResponse> getStats() {
        AnalyticsStatsResponse stats = service.getStatistics();
        return ResponseEntity.ok(stats);
    }
}
