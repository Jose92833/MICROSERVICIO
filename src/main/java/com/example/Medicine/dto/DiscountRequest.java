package com.example.Medicine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DiscountRequest {

    @NotBlank(message = "The description is required")
    @Size(max = 100)
    private String description;

    @NotNull(message = "The percentage is required")
    private Double percentage;

    private Integer minAppointments;
} 