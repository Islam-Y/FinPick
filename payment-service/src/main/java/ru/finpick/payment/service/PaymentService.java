package ru.finpick.payment.service;

import ru.finpick.payment.dto.AuthRequest;
import ru.finpick.payment.dto.AuthResponse;

/**
 * Интерфейс сервиса для авторизации платежей.
 */
public interface PaymentService {

    /**
     * Токенизирует PAN и авторизует транзакцию через EMV/ISO-шлюз.
     *
     * @param request данные для авторизации платежа
     * @return результат авторизации с токеном
     */
    AuthResponse authorize(AuthRequest request);
}
