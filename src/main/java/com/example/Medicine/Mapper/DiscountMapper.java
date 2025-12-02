package com.example.Medicine.Mapper;

import com.example.Medicine.Model.Discount;
import com.example.Medicine.dto.DiscountRequest;
import com.example.Medicine.dto.DiscountResponse;

public final class DiscountMapper {

    public static DiscountResponse toResponse(Discount entity) {
        if (entity == null) {
            return null;
        }
        return DiscountResponse.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .percentage(entity.getPercentage())
                .minAppointments(entity.getMinAppointments())
                .build();
    }

    public static Discount toEntity(DiscountRequest dto) {
        if (dto == null) {
            return null;
        }
        return Discount.builder()
                .description(dto.getDescription())
                .percentage(dto.getPercentage())
                .minAppointments(dto.getMinAppointments())
                .build();
    }

    public static void copyToEntity(DiscountRequest dto, Discount entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setDescription(dto.getDescription());
        entity.setPercentage(dto.getPercentage());
        entity.setMinAppointments(dto.getMinAppointments());
    }
}
