package com.example.Medicine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodResponse {

    @JsonProperty("Payment Method ID")
    private Integer id;

    @JsonProperty("Payment Name")
    private String name;
}
