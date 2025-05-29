package ru.finpick.card.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Конфигурация клиентов банковских API.
 * Задает URL и другие параметры для каждого подключенного банка.
 */
@Configuration
@ConfigurationProperties(prefix = "bank.clients")
@Getter
@Setter
public class BankClientConfig {

    /**
     * Карта настроек по имени банка.
     * Пример в application.yml:
     * bank.clients.sber.url=https://sber.api/cards
     */
    private Map<String, BankProperties> configs;

    /**
     * Внутренний класс, представляющий параметры одного банка.
     */
    @Getter
    @Setter
    public static class BankProperties {

        /**
         * Базовый URL API банка
         */
        private String url;

        /**
         * API-токен для авторизации (если используется)
         */
        private String apiKey;
    }
}