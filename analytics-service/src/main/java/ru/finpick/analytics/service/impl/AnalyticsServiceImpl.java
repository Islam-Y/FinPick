package ru.finpick.analytics.service.impl;

import org.springframework.stereotype.Service;
import ru.finpick.analytics.dto.AnalyticsEventRequest;
import ru.finpick.analytics.dto.AnalyticsEventResponse;
import ru.finpick.analytics.dto.AnalyticsStatsResponse;
import ru.finpick.analytics.model.AnalyticsEvent;
import ru.finpick.analytics.repository.AnalyticsRepository;
import ru.finpick.analytics.service.AnalyticsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Реализация бизнес-логики аналитики.
 */
@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private final AnalyticsRepository repo;

    public AnalyticsServiceImpl(AnalyticsRepository repo) {
        this.repo = repo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnalyticsEventResponse recordEvent(AnalyticsEventRequest request) {
        AnalyticsEvent event = new AnalyticsEvent();
        event.setType(request.getType());
        event.setUserId(request.getUserId());
        event.setPayload(request.getPayload());
        event.setTimestamp(LocalDateTime.now());
        AnalyticsEvent saved = repo.save(event);
        return mapToResponse(saved);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AnalyticsEventResponse> getAllEvents() {
        return repo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AnalyticsStatsResponse getStatistics() {
        AnalyticsStatsResponse stats = new AnalyticsStatsResponse();

        // Статистика по типам событий
        Map<String, Long> countByType = repo.countEventsByType().stream()
                .collect(Collectors.toMap(
                        arr -> (String) arr[0],
                        arr -> ((Number) arr[1]).longValue()
                ));
        stats.setCountByType(countByType);

        // Статистика по пользователям
        Map<Long, Long> countByUser = repo.countEventsByUser().stream()
                .collect(Collectors.toMap(
                        arr -> ((Number) arr[0]).longValue(),
                        arr -> ((Number) arr[1]).longValue()
                ));
        stats.setCountByUser(countByUser);

        return stats;
    }

    /**
     * Вспомогательный метод для конвертации сущности в DTO.
     */
    private AnalyticsEventResponse mapToResponse(AnalyticsEvent e) {
        AnalyticsEventResponse r = new AnalyticsEventResponse();
        r.setId(e.getId());
        r.setType(e.getType());
        r.setUserId(e.getUserId());
        r.setTimestamp(e.getTimestamp());
        r.setPayload(e.getPayload());
        return r;
    }
}