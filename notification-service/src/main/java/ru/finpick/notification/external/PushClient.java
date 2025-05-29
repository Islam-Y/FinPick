package ru.finpick.notification.external;

/**
 * Клиент для отправки push-уведомлений (FCM/APNs).
 */
public interface PushClient {

    /**
     * Отправляет push-уведомление.
     *
     * @param token токен устройства
     * @param body  текст уведомления
     * @return true — если уведомление доставлено
     */
    boolean send(String token, String body);
}
