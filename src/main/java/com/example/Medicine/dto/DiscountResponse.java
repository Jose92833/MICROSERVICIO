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
public class DiscountResponse {

    @JsonProperty("Discount ID")
    private Integer id;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Percentage")
    private Double percentage;

    @JsonProperty("Min Appointments")
    private Integer minAppointments;
}
