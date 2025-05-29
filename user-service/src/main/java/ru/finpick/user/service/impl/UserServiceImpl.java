package ru.finpick.user.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.finpick.user.dto.AuthResponse;
import ru.finpick.user.dto.LoginRequest;
import ru.finpick.user.dto.RegisterRequest;
import ru.finpick.user.dto.UserProfileResponse;
import ru.finpick.user.model.User;
import ru.finpick.user.repository.UserRepository;
import ru.finpick.user.security.JwtTokenProvider;
import ru.finpick.user.service.UserService;

import java.time.LocalDateTime;

/**
 * Реализация UserService: регистрация, аутентификация, получение профиля.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    public UserServiceImpl(UserRepository userRepo,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider tokenProvider) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public UserProfileResponse register(RegisterRequest req) {
        if (userRepo.existsByUsername(req.getUsername())) {
            throw new RuntimeException("Username taken");
        }
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email in use");
        }
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setEmail(req.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        User saved = userRepo.save(user);
        return new UserProfileResponse(saved.getId(), saved.getUsername(), saved.getEmail());
    }

    @Override
    public AuthResponse authenticate(LoginRequest req) {
        User user = userRepo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = tokenProvider.createToken(user.getUsername());
        return new AuthResponse(token, "Bearer");
    }

    @Override
    public UserProfileResponse getProfile(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserProfileResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
