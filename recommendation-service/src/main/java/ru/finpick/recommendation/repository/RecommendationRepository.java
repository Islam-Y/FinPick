package ru.finpick.recommendation.repository;

import ru.finpick.recommendation.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для хранения и доступа к Recommendation.
 */
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
