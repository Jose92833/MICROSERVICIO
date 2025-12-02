package com.example.Medicine.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Medicine.Mapper.InvoiceMapper;
import com.example.Medicine.Model.Invoice;
import com.example.Medicine.Model.Payment;
import com.example.Medicine.Repository.InvoiceRepository;
import com.example.Medicine.Repository.PaymentRepository;
import com.example.Medicine.dto.InvoiceRequest;
import com.example.Medicine.dto.InvoiceResponse;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;
    private final PaymentRepository paymentRepository;

    @Override
    public InvoiceResponse findById(Integer id) {
        Invoice entity = repository.getInvoiceById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found: " + id));
        return InvoiceMapper.toResponse(entity);
    }

    @Override
    public InvoiceResponse create(InvoiceRequest request) {
        // Buscar el Pago asociado
        Payment payment = paymentRepository.findById(request.getPaymentId())
                .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + request.getPaymentId()));

        Invoice entity = InvoiceMapper.toEntity(request, payment);
        entity.setInvoiceDate(LocalDateTime.now()); // Fecha automática

        Invoice saved = repository.save(entity);
        return InvoiceMapper.toResponse(saved);
    }

    @Override
    public InvoiceResponse update(Integer id, InvoiceRequest request) {
        Invoice existing = repository.getInvoiceById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found: " + id));

        Payment payment = paymentRepository.findById(request.getPaymentId())
                .orElseThrow(() -> new EntityNotFoundException("Payment not found: " + request.getPaymentId()));

        InvoiceMapper.copyToEntity(request, existing, payment);
        Invoice saved = repository.save(existing);
        return InvoiceMapper.toResponse(saved);
    }

    @Override
    public List<InvoiceResponse> getInvoiceByNumber(String number) {
        return repository.getInvoicesByNumber(number).stream()
                .map(InvoiceMapper::toResponse)
                .toList();
    }

    @Override
    public List<InvoiceResponse> getInvoiceById(Integer id) {
        return repository.getInvoiceById(id).stream()
                .map(InvoiceMapper::toResponse)
                .toList();
    }
}
