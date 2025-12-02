package com.example.Medicine.Mapper;

import com.example.Medicine.Model.Discount;
import com.example.Medicine.Model.Payment;
import com.example.Medicine.Model.PaymentMethod;
import com.example.Medicine.dto.PaymentRequest;
import com.example.Medicine.dto.PaymentResponse;

public final class PaymentMapper {

    public static PaymentResponse toResponse(Payment entity) {
        if (entity == null) {
            return null;
        }
        return PaymentResponse.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .paymentDate(entity.getPaymentDate())
                
                .paymentMethodId(entity.getPaymentMethod() != null ? entity.getPaymentMethod().getId() : null)
                .discountId(entity.getDiscount() != null ? entity.getDiscount().getId() : null)
                .build();
    }

    public static Payment toEntity(PaymentRequest dto,  PaymentMethod method, Discount discount) {
        if (dto == null) {
            return null;
        }
        return Payment.builder()
                .amount(dto.getAmount())
                
                .paymentMethod(method)
                .discount(discount)
                .build();
    }

    public static void copyToEntity(PaymentRequest dto, Payment entity,  PaymentMethod method, Discount discount) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setAmount(dto.getAmount());
        entity.setPaymentMethod(method);
        entity.setDiscount(discount);
    }
}
