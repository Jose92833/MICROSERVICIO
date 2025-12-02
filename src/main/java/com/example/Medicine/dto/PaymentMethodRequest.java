package com.example.Medicine.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentMethodRequest {

    @NotBlank(message = "The payment name is required")
    @Size(max = 50)
    private String name;
}
