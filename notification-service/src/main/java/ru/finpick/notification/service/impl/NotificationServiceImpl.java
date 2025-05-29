package ru.finpick.notification.service.impl;

import ru.finpick.notification.dto.NotificationRequest;
import ru.finpick.notification.dto.NotificationResponse;
import ru.finpick.notification.external.EmailClient;
import ru.finpick.notification.external.PushClient;
import ru.finpick.notification.model.NotificationLog;
import ru.finpick.notification.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;
import ru.finpick.notification.service.NotificationService;

import java.time.LocalDateTime;

/**
 * Реализация сервиса отправки уведомлений.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private final EmailClient emailClient;
    private final PushClient pushClient;
    private final NotificationLogRepository repository;

    public NotificationServiceImpl(EmailClient emailClient,
                                   PushClient pushClient,
                                   NotificationLogRepository repository) {
        this.emailClient = emailClient;
        this.pushClient = pushClient;
        this.repository = repository;
    }

    @Override
    public NotificationResponse send(NotificationRequest request) {
        NotificationLog log = new NotificationLog();
        log.setType(request.getType());
        log.setRecipient(request.getRecipient());
        log.setSubject(request.getSubject());
        log.setBody(request.getBody());
        log.setTimestamp(LocalDateTime.now());

        boolean success;
        String errorMsg = null;

        if ("EMAIL".equalsIgnoreCase(request.getType())) {
            success = emailClient.send(request.getRecipient(), request.getSubject(), request.getBody());
        } else {
            success = pushClient.send(request.getRecipient(), request.getBody());
        }

        log.setStatus(success ? "SENT" : "FAILED");
        if (!success) {
            errorMsg = "Delivery error";
            log.setError(errorMsg);
        }
        repository.save(log);

        NotificationResponse resp = new NotificationResponse();
        resp.setLogId(log.getId());
        resp.setStatus(log.getStatus());
        resp.setError(errorMsg);
        return resp;
    }
}