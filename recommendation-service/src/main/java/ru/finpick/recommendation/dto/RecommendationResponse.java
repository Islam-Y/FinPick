package ru.finpick.recommendation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * DTO-ответ с перечнем персональных рекомендаций.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationResponse {

    /** Список рекомендаций для пользователя */
    private List<RecommendationItem> recommendations;

    /**
     * Вложенный класс — единичная рекомендация.
     */
    @Getter
    @Setter
    public static class RecommendationItem {
        /** Текст рекомендации (например, «Используйте карту X для А»). */
        private String text;
        /** Уровень приоритета или полезности (чем выше — тем лучше). */
        private Double score;
    }
}