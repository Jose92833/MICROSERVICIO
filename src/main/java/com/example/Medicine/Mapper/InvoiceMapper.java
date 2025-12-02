package com.example.Medicine.Mapper;

import com.example.Medicine.Model.Invoice;
import com.example.Medicine.Model.Payment;
import com.example.Medicine.dto.InvoiceRequest;
import com.example.Medicine.dto.InvoiceResponse;

public final class InvoiceMapper {

    public static InvoiceResponse toResponse(Invoice entity) {
        if (entity == null) {
            return null;
        }
        return InvoiceResponse.builder()
                .id(entity.getId())
                .invoiceNumber(entity.getInvoiceNumber())
                .invoiceDate(entity.getInvoiceDate())
                .total(entity.getTotal())
                .paymentId(entity.getPayment() != null ? entity.getPayment().getId() : null)
                .build();
    }

    public static Invoice toEntity(InvoiceRequest dto, Payment payment) {
        if (dto == null) {
            return null;
        }
        return Invoice.builder()
                .invoiceNumber(dto.getInvoiceNumber())
                .total(dto.getTotal())
                .payment(payment)
                .build();
    }

    public static void copyToEntity(InvoiceRequest dto, Invoice entity, Payment payment) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setInvoiceNumber(dto.getInvoiceNumber());
        entity.setTotal(dto.getTotal());
        entity.setPayment(payment);
    }
}

