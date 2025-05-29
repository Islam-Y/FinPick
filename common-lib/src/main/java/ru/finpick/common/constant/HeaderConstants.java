package ru.finpick.common.constant;

/**
 * Общие HTTP-заголовки, используемые в FinPick.
 */
public final class HeaderConstants {

    /** Заголовок с JWT-токеном: «Authorization: Bearer …» */
    public static final String AUTHORIZATION = "Authorization";

    /** Заголовок для версии API */
    public static final String API_VERSION = "X-Api-Version";

    private HeaderConstants() {
        // ни унаследовать, ни инстанцировать
    }
}
