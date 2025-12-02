package com.example.Medicine.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Integer id;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "percentage", nullable = false)
    private Double percentage;

    @Column(name = "min_appointments")
    private Integer minAppointments;

    @OneToMany(mappedBy = "discount")
    @Builder.Default
    private List<Payment> payments = new ArrayList<>();
}
