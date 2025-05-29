package ru.finpick.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Базовый ответ API — содержит код и сообщение, данные опциональны.
 *
 * @param <T> тип полезной нагрузки
 */
@Getter
@Setter
public class BaseResponse<T> {

    /** Код статуса операции (например, 0 — успех, иначе ошибка) */
    private int code;

    /** Читаемое сообщение о результате */
    private String message;

    /** Полезные данные (например, DTO конкретного ответа) */
    private T data;

    public BaseResponse() {}

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
