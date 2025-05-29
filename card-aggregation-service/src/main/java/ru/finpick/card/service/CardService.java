package ru.finpick.card.service;

import ru.finpick.card.dto.CardInfoResponse;

import java.util.List;

/**
 * Интерфейс сервиса агрегации карт.
 */
public interface CardService {

    /**
     * Получает и нормализует данные о картах пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список информации о картах
     */
    List<CardInfoResponse> getCardsForUser(Long userId);
}