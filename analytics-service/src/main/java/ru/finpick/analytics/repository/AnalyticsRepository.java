package ru.finpick.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.finpick.analytics.model.AnalyticsEvent;

import java.util.List;

/**
 * Репозиторий для работы с событиями аналитики.
 */
public interface AnalyticsRepository extends JpaRepository<AnalyticsEvent, Long> {

    /**
     * Возвращает список пар [type, count].
     */
    @Query("SELECT e.type, COUNT(e) FROM AnalyticsEvent e GROUP BY e.type")
    List<Object[]> countEventsByType();

    /**
     * Возвращает список пар [userId, count].
     */
    @Query("SELECT e.userId, COUNT(e) FROM AnalyticsEvent e GROUP BY e.userId")
    List<Object[]> countEventsByUser();
}
