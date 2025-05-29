package ru.finpick.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Входные данные банковской карты для эмуляции NFC-платежа и токенизации.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardInfo {
    /** PAN (Primary Account Number) — номер карты, подлежит токенизации */
    private String cardNumber;

    /** CVV — код безопасности на обороте карты */
    private String cvv;

    /** Expiry date — срок действия карты в формате MM/yy */
    private String expiry;

    /** Сумма транзакции в валюте, принятой по умолчанию (например, RUB) */
    private BigDecimal amount;
}