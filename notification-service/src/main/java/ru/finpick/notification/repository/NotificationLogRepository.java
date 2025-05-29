package ru.finpick.notification.repository;

import ru.finpick.notification.model.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для доступа к логам уведомлений.
 */
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
