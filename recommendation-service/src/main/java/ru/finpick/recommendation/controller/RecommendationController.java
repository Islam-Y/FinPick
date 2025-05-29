package ru.finpick.recommendation.controller;

import ru.finpick.recommendation.dto.RecommendationRequest;
import ru.finpick.recommendation.dto.RecommendationResponse;
import ru.finpick.recommendation.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST-контроллер для выдачи персональных финансовых рекомендаций.
 */
@RestController
@RequestMapping("/api/v1/rerumendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    /**
     * Генерирует список рекомендаций на основании транзакционной истории пользователя.
     *
     * @param request параметры запроса: пользователь, период, лимит
     * @return список рекомендаций и их оценки
     */
    @PostMapping
    public ResponseEntity<RecommendationResponse> getRecommendations(
            @RequestBody RecommendationRequest request) {
        RecommendationResponse response = recommendationService.generate(request);
        return ResponseEntity.ok(response);
    }
}
