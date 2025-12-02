package com.example.Medicine.Mapper;

import com.example.Medicine.Model.PaymentMethod;
import com.example.Medicine.dto.PaymentMethodRequest;
import com.example.Medicine.dto.PaymentMethodResponse;

public final class PaymentMethodMapper {

    public static PaymentMethodResponse toResponse(PaymentMethod entity) {
        if (entity == null) {
            return null;
        }
        return PaymentMethodResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static PaymentMethod toEntity(PaymentMethodRequest dto) {
        if (dto == null) {
            return null;
        }
        return PaymentMethod.builder()
                .name(dto.getName())
                .build();
    }

    public static void copyToEntity(PaymentMethodRequest dto, PaymentMethod entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setName(dto.getName());
    }
}
