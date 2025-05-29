package ru.finpick.recommendation.service.impl;

import ru.finpick.recommendation.dto.RecommendationRequest;
import ru.finpick.recommendation.dto.RecommendationResponse;
import ru.finpick.recommendation.external.TensorflowModelClient;
import ru.finpick.recommendation.model.Recommendation;
import ru.finpick.recommendation.repository.RecommendationRepository;
import org.springframework.stereotype.Service;
import ru.finpick.recommendation.service.RecommendationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация RecommendationService: вызывает ML-модель и сохраняет результаты.
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final TensorflowModelClient modelClient;
    private final RecommendationRepository repository;

    public RecommendationServiceImpl(TensorflowModelClient modelClient,
                                     RecommendationRepository repository) {
        this.modelClient = modelClient;
        this.repository = repository;
    }

    @Override
    public RecommendationResponse generate(RecommendationRequest request) {
        // Вызов внешнего клиента с историей транзакций
        List<Recommendation> recs = modelClient.predict(
                request.getUserId(),
                request.getFromDate(),
                request.getToDate(),
                request.getLimit()
        );

        // Сохранить историю рекомендаций (опционально)
        repository.saveAll(recs);

        // Сконвертировать в DTO
        RecommendationResponse response = new RecommendationResponse();
        response.setRecommendations(
                recs.stream()
                        .map(r -> {
                            RecommendationResponse.RecommendationItem item =
                                    new RecommendationResponse.RecommendationItem();
                            item.setText(r.getText());
                            item.setScore(r.getScore());
                            return item;
                        })
                        .collect(Collectors.toList())
        );
        return response;
    }
}

