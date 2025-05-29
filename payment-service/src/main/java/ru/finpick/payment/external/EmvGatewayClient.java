package ru.finpick.payment.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Feign-клиент для внешнего шлюза EMV/ISO 14443.
 */
@FeignClient(
        name = "emv-gateway",
        url = "${emv.gateway.url}"    // см. application.yml
)
public interface EmvGatewayClient {

    /**
     * Авторизация транзакции у платёжного провайдера.
     * @param token токен вместо PAN
     * @param amount сумма
     * @return true — если провайдер вернул успех
     */
    @PostMapping("/api/v1/external/authorize")
    boolean authorize(
            @RequestParam("token") String token,
            @RequestParam("amount") BigDecimal amount
    );
}
