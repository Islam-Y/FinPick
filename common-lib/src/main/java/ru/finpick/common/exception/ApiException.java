package ru.finpick.common.exception;

/**
 * Базовое unchecked-исключение для ошибок API.
 */
public class ApiException extends RuntimeException {

    /** HTTP-статус для ответа (например, 400, 404, 500) */
    private final int httpStatus;

    public ApiException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}