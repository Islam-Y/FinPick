package ru.finpick.recommendation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Сущность для хранения результатов рекомендаций.
 */
@Getter
@Setter
@Entity
public class Recommendation {

    /** PK — автогенерируемый идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Идентификатор пользователя */
    private Long userId;

    /** Дата, когда сгенерирована рекомендация */
    private LocalDate generatedAt;

    /** Текст рекомендации */
    @Column(length = 1024)
    private String text;

    /** Оценка полезности рекомендации */
    private Double score;
}
