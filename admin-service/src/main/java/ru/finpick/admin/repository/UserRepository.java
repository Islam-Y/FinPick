package ru.finpick.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finpick.admin.model.User;

/**
 * Репозиторий для доступа к данным пользователей.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
