package ru.finpick.payment.service.impl;

import ru.finpick.payment.dto.AuthRequest;
import ru.finpick.payment.dto.AuthResponse;
import ru.finpick.payment.external.EmvGatewayClient;
import ru.finpick.payment.model.PaymentTransaction;
import ru.finpick.payment.repository.PaymentTransactionRepository;
import org.springframework.stereotype.Service;
import ru.finpick.payment.service.PaymentService;

import java.time.LocalDateTime;

/**
 * Реализация сервиса платежей: токенизация PAN, вызов шлюза, сохранение транзакции.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final EmvGatewayClient emvClient;
    private final PaymentTransactionRepository repository;

    public PaymentServiceImpl(EmvGatewayClient emvClient,
                              PaymentTransactionRepository repository) {
        this.emvClient = emvClient;
        this.repository = repository;
    }

    @Override
    public AuthResponse authorize(AuthRequest request) {
        // Токенизация PAN
        String token = "tok_" + request.getPan().hashCode();

        // Авторизация транзакции
        boolean success = emvClient.authorize(token, request.getAmount());

        // Сохранение в БД
        PaymentTransaction tx = new PaymentTransaction();
        tx.setToken(token);
        tx.setAmount(request.getAmount());
        tx.setStatus(success ? "SUCCESS" : "FAILED");
        tx.setTimestamp(LocalDateTime.now());
        repository.save(tx);

        // Формирование ответа
        AuthResponse resp = new AuthResponse();
        resp.setToken(token);
        resp.setStatus(success ? "SUCCESS" : "FAILED");
        return resp;
    }
}
