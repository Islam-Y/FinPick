package ru.finpick.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Вспомогательные методы для работы с датой и временем.
 */
public final class DateTimeUtils {

    /** Форматер ISO-дат времени без зоны: yyyy-MM-dd HH:mm:ss */
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private DateTimeUtils() { }

    /**
     * Преобразует LocalDateTime в строку в формате yyyy-MM-dd HH:mm:ss.
     */
    public static String format(LocalDateTime dt) {
        return dt.format(FORMATTER);
    }

    /**
     * Парсит строку вида yyyy-MM-dd HH:mm:ss в LocalDateTime.
     */
    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text, FORMATTER);
    }
}
