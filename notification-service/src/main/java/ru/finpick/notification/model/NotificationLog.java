package ru.finpick.notification.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Сущность для логирования отправленных уведомлений.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationLog {

    /** PK — автогенерируемый идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Тип уведомления: EMAIL или PUSH */
    private String type;

    /** Адрес получателя (email или push-токен) */
    private String recipient;

    /** Тема письма (для EMAIL) */
    private String subject;

    /** Тело уведомления */
    @Column(length = 2048)
    private String body;

    /** Время отправки */
    private LocalDateTime timestamp;

    /** Статус: SENT или FAILED */
    private String status;

    /** Текст ошибки при неудаче */
    private String error;
}
