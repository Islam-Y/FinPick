package ru.finpick.card.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO для передачи клиенту информации о карте.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardInfoResponse {

    /** Уникальный идентификатор записи */
    private Long id;

    /** Название банка-эмитента */
    private String bankName;

    /** Токенизированный или маскированный PAN карты */
    private String maskedPan;

    /** Текущий баланс по карте */
    private BigDecimal balance;

    /** Накопленный кэшбэк */
    private BigDecimal cashback;

    /** Список активных льготных категорий (например, "АЗС", "Рестораны") */
    private List<String> rewardCategories;
}
