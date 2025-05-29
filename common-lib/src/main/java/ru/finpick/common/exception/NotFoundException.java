package ru.finpick.common.exception;

/**
 * Ошибка «Не найдено» — возвращает 404.
 */
public class NotFoundException extends ApiException {
    public NotFoundException(String entity, Object id) {
        super(404, entity + " с id=" + id + " не найден");
    }
}
