package com.example.Medicine.Service;

import com.example.Medicine.dto.PaymentRequest;
import com.example.Medicine.dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse findById(Integer id);

    PaymentResponse create(PaymentRequest req);

    PaymentResponse update(Integer id, PaymentRequest req);

}
