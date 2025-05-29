package ru.finpick.payment.controller;

import ru.finpick.payment.dto.AuthRequest;
import ru.finpick.payment.dto.AuthResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-контроллер для авторизации NFC-платежей.
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Принимает данные карты, проводит токенизацию и авторизацию через шлюз.
     *
     * @param request данные для авторизации платежа
     * @return токен и статус операции
     */
    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest request) {
        AuthResponse response = paymentService.authorize(request);
        return ResponseEntity.ok(response);
    }
}
