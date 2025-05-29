package ru.finpick.notification.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO-запрос для отправки уведомления.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    /** Тип уведомления: EMAIL или PUSH */
    @NotBlank
    private String type;

    /** Адрес электронной почты (для EMAIL) или push-токен (для PUSH) */
    @NotBlank
    private String recipient;

    /** Заголовок сообщения */
    private String subject;

    /** Текст уведомления */
    @NotBlank
    private String body;

    // getters и setters
}
