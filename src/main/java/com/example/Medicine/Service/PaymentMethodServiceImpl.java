package com.example.Medicine.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Medicine.Mapper.PaymentMethodMapper;
import com.example.Medicine.Model.PaymentMethod;
import com.example.Medicine.Repository.PaymentMethodRepository;
import com.example.Medicine.dto.PaymentMethodRequest;
import com.example.Medicine.dto.PaymentMethodResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository repository;

    @Override
    public PaymentMethodResponse findById(Integer id) {
        PaymentMethod entity = repository.getPaymentMethodById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment method not found: " + id));
        return PaymentMethodMapper.toResponse(entity);
    }

    @Override
    public PaymentMethodResponse create(PaymentMethodRequest request) {
        PaymentMethod saved = repository.save(PaymentMethodMapper.toEntity(request));
        return PaymentMethodMapper.toResponse(saved);
    }

    @Override
    public PaymentMethodResponse update(Integer id, PaymentMethodRequest request) {
        PaymentMethod existing = repository.getPaymentMethodById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment method not found: " + id));

        PaymentMethodMapper.copyToEntity(request, existing);
        PaymentMethod saved = repository.save(existing);
        return PaymentMethodMapper.toResponse(saved);
    }

    @Override
    public List<PaymentMethodResponse> getPaymentMethodByName(String name) {
        return repository.getPaymentMethodsByName(name).stream()
                .map(PaymentMethodMapper::toResponse)
                .toList();
    }

}
