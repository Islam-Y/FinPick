package ru.finpick.card.external;

import ru.finpick.card.model.CardInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign-клиент для вызова API банков-эмитентов.
 */
@FeignClient(name = "bank-api", url = "${bank.api.url}")
public interface BankApiClient {

    /**
     * Получает список карт и их метрик для пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список CardInfo
     */
    @GetMapping("/external/api/v1/cards")
    List<CardInfo> fetchCards(@RequestParam("userId") Long userId);
}