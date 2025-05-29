package ru.finpick.card.repository;

import ru.finpick.card.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для кеширования/хранения CardInfo.
 */
public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
}