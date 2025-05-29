package ru.finpick.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO-ответ после попытки отправки уведомления.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {

    /** Уникальный идентификатор записи в логе */
    private Long logId;

    /** Статус отправки: SENT или FAILED */
    private String status;

    /** Текст ошибки, если отправка не удалась */
    private String error;
}
