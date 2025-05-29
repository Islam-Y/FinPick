package ru.finpick.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.finpick.admin.dto.SystemStatsResponse;
import ru.finpick.admin.dto.UserProfileResponse;
import ru.finpick.admin.dto.UserRoleUpdateRequest;
import ru.finpick.admin.service.AdminService;

import java.util.List;

/**
 * REST-контроллер для операций администратора.
 */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Возвращает список всех пользователей.
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserProfileResponse>> listUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    /**
     * Изменяет роль пользователя.
     */
    @PostMapping("/users/role")
    public ResponseEntity<Void> updateRole(
            @RequestBody UserRoleUpdateRequest request) {
        adminService.updateUserRole(request);
        return ResponseEntity.noContent().build();
    }

    /**
     * Возвращает текущие системные метрики.
     */
    @GetMapping("/stats")
    public ResponseEntity<SystemStatsResponse> getStats() {
        return ResponseEntity.ok(adminService.getSystemStats());
    }
}
