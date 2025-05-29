package ru.finpick.recommendation.service;

import ru.finpick.recommendation.dto.RecommendationRequest;
import ru.finpick.recommendation.dto.RecommendationResponse;

/**
 * Сервис для формирования персонализированных рекомендаций.
 */
public interface RecommendationService {

    /**
     * Обрабатывает запрос и генерирует рекомендации.
     *
     * @param request параметры: userId, период, лимит
     * @return DTO с перечнем рекомендаций
     */
    RecommendationResponse generate(RecommendationRequest request);
}
