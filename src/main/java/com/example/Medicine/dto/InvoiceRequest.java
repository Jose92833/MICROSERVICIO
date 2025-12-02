package com.example.Medicine.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InvoiceRequest {

    @NotNull(message = "The payment ID is required")
    private Integer paymentId;

    @NotBlank(message = "The invoice number is required")
    @Size(max = 50)
    private String invoiceNumber;

    @NotNull(message = "The total amount is required")
    private Double total;
}
