package com.example.Medicine.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Medicine.Model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    @Query(value = "SELECT * FROM discounts WHERE discount_id = :id", nativeQuery = true)
    Optional<Discount> getDiscountById(@Param("id") Integer id);
}
