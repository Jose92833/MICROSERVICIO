package com.example.Medicine.Service;
import java.util.List;

import com.example.Medicine.dto.PaymentMethodRequest;
import com.example.Medicine.dto.PaymentMethodResponse;


public interface PaymentMethodService {

    PaymentMethodResponse findById(Integer id);

    PaymentMethodResponse create(PaymentMethodRequest req);

    PaymentMethodResponse update(Integer id, PaymentMethodRequest req);

    List<PaymentMethodResponse> getPaymentMethodByName(String name);
}
