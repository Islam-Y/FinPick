package ru.finpick.user.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.finpick.user.dto.AuthResponse;
import ru.finpick.user.dto.LoginRequest;
import ru.finpick.user.dto.RegisterRequest;
import ru.finpick.user.dto.UserProfileResponse;
import ru.finpick.user.service.UserService;

/**
 * Контроллер для регистрации, входа и профиля пользователя.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserProfileResponse> register(
            @Valid @RequestBody RegisterRequest req) {
        return ResponseEntity.ok(userService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(userService.authenticate(req));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> profile(
            @RequestHeader("Authorization") String authHeader) {
        String username = authHeader.substring(7); // извлечь из Bearer
        return ResponseEntity.ok(userService.getProfile(username));
    }
}
