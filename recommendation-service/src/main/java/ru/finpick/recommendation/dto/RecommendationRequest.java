package ru.finpick.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO-запрос для получения персональной рекомендации.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {

    /** Идентификатор пользователя в системе FinPick */
    private Long userId;

    /** Дата начала анализируемого периода */
    private LocalDate fromDate;

    /** Дата конца анализируемого периода */
    private LocalDate toDate;

    /** Максимальное число рекомендаций, которое хочет получить клиент */
    private Integer limit;
}
