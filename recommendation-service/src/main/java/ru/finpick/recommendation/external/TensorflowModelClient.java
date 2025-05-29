package ru.finpick.recommendation.external;

import ru.finpick.recommendation.model.Recommendation;

import java.time.LocalDate;
import java.util.List;

/**
 * Клиент для работы с ML-моделью на TensorFlow (Java).
 */
public interface TensorflowModelClient {

    /**
     * Вычисляет персональные рекомендации на основании транзакционной истории.
     *
     * @param userId   уникальный идентификатор пользователя
     * @param fromDate начало периода для анализа
     * @param toDate   конец периода для анализа
     * @param limit    максимальное число рекомендаций
     * @return список объектов Recommendation
     */
    List<Recommendation> predict(Long userId,
                                 LocalDate fromDate,
                                 LocalDate toDate,
                                 Integer limit);
}
