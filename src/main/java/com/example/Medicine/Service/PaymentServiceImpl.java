package com.example.Medicine.Service;

import org.springframework.stereotype.Service;

import com.example.Medicine.Mapper.PaymentMapper;
import com.example.Medicine.Model.Discount;
import com.example.Medicine.Model.Payment;
import com.example.Medicine.Model.PaymentMethod;
import com.example.Medicine.Repository.DiscountRepository;
import com.example.Medicine.Repository.PaymentMethodRepository;
import com.example.Medicine.Repository.PaymentRepository;
import com.example.Medicine.dto.PaymentRequest;
import com.example.Medicine.dto.PaymentResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final DiscountRepository discountRepository;

    // ============================================================
    // CREATE
    // ============================================================
    @Override
    public PaymentResponse create(PaymentRequest request) {

        // Obtener método de pago
        PaymentMethod method = paymentMethodRepository.findById(request.getPaymentMethodId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Payment Method not found: " + request.getPaymentMethodId()));

        // Obtener descuento (si se envió uno)
        Discount discount = null;
        if (request.getDiscountId() != null) {
            discount = discountRepository.findById(request.getDiscountId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Discount not found: " + request.getDiscountId()));
        }

        // Crear el pago
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(method);
        payment.setDiscount(discount);

        payment = repository.save(payment);

        return PaymentMapper.toResponse(payment);
    }

    // ============================================================
    // FIND BY ID
    // ============================================================
    @Override
    public PaymentResponse findById(Integer id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + id));

        return PaymentMapper.toResponse(payment);
    }

    // ============================================================
    // UPDATE
    // ============================================================
    @Override
    public PaymentResponse update(Integer id, PaymentRequest req) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + id));

        // Actualizar monto
        payment.setAmount(req.getAmount());

        // Actualizar método de pago
        PaymentMethod method = paymentMethodRepository.findById(req.getPaymentMethodId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Payment Method not found: " + req.getPaymentMethodId()));
        payment.setPaymentMethod(method);

        // Actualizar descuento
        if (req.getDiscountId() != null) {
            Discount discount = discountRepository.findById(req.getDiscountId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Discount not found: " + req.getDiscountId()));
            payment.setDiscount(discount);
        } else {
            payment.setDiscount(null);
        }

        repository.save(payment);

        return PaymentMapper.toResponse(payment);
    }
}