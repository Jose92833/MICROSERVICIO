package com.example.Medicine.Service;

import com.example.Medicine.dto.DiscountRequest;
import com.example.Medicine.dto.DiscountResponse;

public interface DiscountService {

    DiscountResponse findById(Integer id);

    DiscountResponse create(DiscountRequest req);

    DiscountResponse update(Integer id, DiscountRequest req);

}