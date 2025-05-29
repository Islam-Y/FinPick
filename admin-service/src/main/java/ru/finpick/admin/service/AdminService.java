package ru.finpick.admin.service;

import ru.finpick.admin.dto.SystemStatsResponse;
import ru.finpick.admin.dto.UserProfileResponse;
import ru.finpick.admin.dto.UserRoleUpdateRequest;

import java.util.List;

/**
 * Бизнес-логика административных операций.
 */
public interface AdminService {

    /**
     * Получает список всех пользователей.
     */
    List<UserProfileResponse> getAllUsers();

    /**
     * Обновляет роль указанного пользователя.
     *
     * @param request содержит userId и новую роль
     */
    void updateUserRole(UserRoleUpdateRequest request);

    /**
     * Считает и возвращает системную статистику.
     */
    SystemStatsResponse getSystemStats();
}
