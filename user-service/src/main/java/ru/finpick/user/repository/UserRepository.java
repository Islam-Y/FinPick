package ru.finpick.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finpick.user.model.User;

import java.util.Optional;

/**
 * Репозиторий для работы с пользователями.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /** Поиск по логину */
    Optional<User> findByUsername(String username);

    /** Проверка наличия логина */
    boolean existsByUsername(String username);

    /** Проверка наличия email */
    boolean existsByEmail(String email);
}
