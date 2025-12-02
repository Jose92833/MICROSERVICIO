package com.example.Medicine.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Medicine.Model.PaymentMethod;
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

    @Query(value = "SELECT * FROM payment_methods WHERE payment_method_id = :id", nativeQuery = true)
    Optional<PaymentMethod> getPaymentMethodById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM payment_methods WHERE LOWER(payment_name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
    List<PaymentMethod> getPaymentMethodsByName(@Param("name") String name);
}