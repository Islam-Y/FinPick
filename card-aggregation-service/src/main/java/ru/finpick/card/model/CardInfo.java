package ru.finpick.card.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Внутренняя модель для хранения ответа банковского API.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardInfo {

    /** Идентификатор записи */
    private Long id;

    /** Номер карты (PAN) в незашифрованном виде */
    private String pan;

    /** Название банка-эмитента */
    private String issuer;

    /** Текущий баланс по карте */
    private BigDecimal balance;

    /** Накопленный кэшбэк */
    private BigDecimal cashback;

    /** Список льготных категорий покупок */
    private List<String> categories;
}
