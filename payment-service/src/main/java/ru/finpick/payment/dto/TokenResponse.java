package ru.finpick.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * Ответ клиенту после обработки платежа и токенизации карты.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    /** Токенизированный идентификатор карты */
    private String token;

    /** Статус выполнения платежа: SUCCESS или FAILED */
    private String status;
}
