package ru.finpick.card.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.finpick.card.dto.CardInfoResponse;
import ru.finpick.card.service.CardService;

import java.util.List;

/**
 * REST-контроллер для агрегации данных по банковским картам.
 */
@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    /**
     * Возвращает список карт и их параметров для пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список DTO с информацией о картах
     */
    @GetMapping
    public ResponseEntity<List<CardInfoResponse>> getCards(
            @RequestParam("userId") Long userId) {
        List<CardInfoResponse> list = cardService.getCardsForUser(userId);
        return ResponseEntity.ok(list);
    }
}