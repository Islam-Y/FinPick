package ru.finpick.notification.controller;

import ru.finpick.notification.dto.NotificationRequest;
import ru.finpick.notification.dto.NotificationResponse;
import ru.finpick.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * REST-контроллер для отправки уведомлений.
 */
@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Принимает запрос на отправку уведомления и возвращает результат.
     *
     * @param request параметры уведомления
     * @return статус отправки и лог-id
     */
    @PostMapping
    public ResponseEntity<NotificationResponse> sendNotification(
            @Validated @RequestBody NotificationRequest request) {
        NotificationResponse response = notificationService.send(request);
        return ResponseEntity.ok(response);
    }
}