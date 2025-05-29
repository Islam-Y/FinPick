package ru.finpick.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.finpick.payment.model.PaymentTransaction;

/**
 * Репозиторий для доступа к транзакциям в базе данных.
 */
@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
}
