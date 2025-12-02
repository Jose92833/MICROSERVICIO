package com.example.Medicine.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Medicine.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "SELECT * FROM payments WHERE payment_id = :id", nativeQuery = true)
    Optional<Payment> getPaymentById(@Param("id") Integer id);
}
