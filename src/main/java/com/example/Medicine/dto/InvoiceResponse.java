package com.example.Medicine.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {

    @JsonProperty("Invoice ID")
    private Integer id;

    @JsonProperty("Invoice Number")
    private String invoiceNumber;

    @JsonProperty("Invoice Date")
    private LocalDateTime invoiceDate;

    @JsonProperty("Total")
    private Double total;

    @JsonProperty("Payment ID")
    private Integer paymentId;
}
