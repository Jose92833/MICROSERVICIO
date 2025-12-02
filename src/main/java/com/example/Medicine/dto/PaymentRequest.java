package com.example.Medicine.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {

   

    @NotNull(message = "The amount is required")
    private Double amount;

    @NotNull(message = "The payment method ID is required")
    private Integer paymentMethodId;

    private Integer discountId;
}
