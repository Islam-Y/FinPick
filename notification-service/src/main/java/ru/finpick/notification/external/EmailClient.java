package ru.finpick.notification.external;

/**
 * Клиент для отправки email-уведомлений через SMTP.
 */
public interface EmailClient {

    /**
     * Отправляет email.
     *
     * @param to      email-адрес получателя
     * @param subject тема письма
     * @param body    содержимое письма
     * @return true — если письмо отправлено успешно
     */
    boolean send(String to, String subject, String body);
}