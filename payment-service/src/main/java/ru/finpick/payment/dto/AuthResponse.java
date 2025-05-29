package ru.finpick.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Ответ после авторизации платежа.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    /** Токенизированный идентификатор карты */
    private String token;

    /** Статус выполнения операции: SUCCESS или FAILED */
    private String status;
}
