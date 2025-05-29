package ru.finpick.card.service.impl;

import ru.finpick.card.dto.BankClientConfig;
import ru.finpick.card.dto.CardInfoResponse;
import ru.finpick.card.external.BankApiClient;
import ru.finpick.card.model.CardInfo;
import org.springframework.stereotype.Service;
import ru.finpick.card.service.CardService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация CardService: обращается к банковским API и нормализует ответы.
 */
@Service
public class CardServiceImpl implements CardService {

    private final BankApiClient bankClient;
    private final BankClientConfig config;

    public CardServiceImpl(BankApiClient bankClient, BankClientConfig config) {
        this.bankClient = bankClient;
        this.config = config;
    }

    @Override
    public List<CardInfoResponse> getCardsForUser(Long userId) {
        // вызываем внешний клиент, получаем модели CardInfo
        List<CardInfo> rawList = bankClient.fetchCards(userId);
        // нормализация в DTO
        return rawList.stream().map(ci -> {
            CardInfoResponse dto = new CardInfoResponse();
            dto.setId(ci.getId());
            dto.setBankName(ci.getIssuer());
            dto.setMaskedPan(maskPan(ci.getPan()));
            dto.setBalance(ci.getBalance());
            dto.setCashback(ci.getCashback());
            dto.setRewardCategories(ci.getCategories());
            return dto;
        }).collect(Collectors.toList());
    }

    private String maskPan(String pan) {
        if (pan.length() >= 8) {
            return "**** **** **** " + pan.substring(pan.length() - 4);
        }
        return pan;
    }

    public void printUrls() {
        config.getConfigs().forEach((bank, props) -> {
            System.out.println(bank + " => " + props.getUrl());
        });
    }
}