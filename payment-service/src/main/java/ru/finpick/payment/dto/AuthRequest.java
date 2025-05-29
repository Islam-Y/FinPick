package ru.finpick.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Запрос на авторизацию.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    /** PAN (Primary Account Number) — номер карты, подлежит токенизации */
    private String pan;

    /** CVV — код безопасности на обороте карты */
    private String cvv;

    /** Expiry date — срок действия карты в формате MM/yy */
    private String expiry;

    /** Сумма операции в валюте по умолчанию (например, RUB) */
    private BigDecimal amount;

}
