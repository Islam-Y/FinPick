package ru.finpick.admin.service.impl;

import org.springframework.stereotype.Service;
import ru.finpick.admin.dto.SystemStatsResponse;
import ru.finpick.admin.dto.UserProfileResponse;
import ru.finpick.admin.dto.UserRoleUpdateRequest;
import ru.finpick.admin.model.User;
import ru.finpick.admin.repository.UserRepository;
import ru.finpick.admin.service.AdminService;

import java.util.List;

/**
 * Реализация бизнес-логики административных операций.
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepo;
    // в реале можно подключить ещё репозитории payment, analytics и т.д.

    public AdminServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserProfileResponse> getAllUsers() {
        return userRepo.findAll().stream().map(u -> {
            UserProfileResponse dto = new UserProfileResponse();
            dto.setId(u.getId());
            dto.setUsername(u.getUsername());
            dto.setEmail(u.getEmail());
            dto.setRole(u.getRole());
            return dto;
        }).toList();
    }

    @Override
    public void updateUserRole(UserRoleUpdateRequest request) {
        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(request.getNewRole());
        userRepo.save(user);
    }

    @Override
    public SystemStatsResponse getSystemStats() {
        long total = userRepo.count();
        // заглушки — в реале берутся из репозиториев других сервисов
        long todayEvents = 123;
        long todayPayments = 45;
        SystemStatsResponse stats = new SystemStatsResponse();
        stats.setTotalUsers(total);
        stats.setTodayAnalyticsEvents(todayEvents);
        stats.setTodayPayments(todayPayments);
        return stats;
    }
}
