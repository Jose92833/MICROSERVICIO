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
public class PaymentResponse {

    @JsonProperty("Payment ID")
    private Integer id;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Payment Date")
    private LocalDateTime paymentDate;

   

    @JsonProperty("Payment Method ID")
    private Integer paymentMethodId;

    @JsonProperty("Discount ID")
    private Integer discountId;
}
