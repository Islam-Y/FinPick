package ru.finpick.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Сущность для хранения данных об обработанных транзакциях.
 */
@Entity
@Getter
@Setter
public class PaymentTransaction {

    /** Идентификатор транзакции (автоинкремент) */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Токен, полученный при токенизации PAN */
    private String token;

    /** Сумма операции */
    private BigDecimal amount;

    /** Временная метка проведения транзакции */
    private LocalDateTime timestamp;

    /** Статус транзакции: SUCCESS, FAILED */
    private String status;

}
