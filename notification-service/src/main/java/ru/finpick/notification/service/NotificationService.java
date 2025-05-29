package ru.finpick.notification.service;

import ru.finpick.notification.dto.NotificationRequest;
import ru.finpick.notification.dto.NotificationResponse;

/**
 * Интерфейс бизнес-логики по отправке уведомлений.
 */
public interface NotificationService {

    /**
     * Отправляет уведомление через нужный канал и сохраняет его в лог.
     *
     * @param request данные уведомления
     * @return результат отправки
     */
    NotificationResponse send(NotificationRequest request);
}
