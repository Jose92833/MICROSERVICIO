package com.example.Medicine.Service;

import com.example.Medicine.Mapper.DiscountMapper;
import com.example.Medicine.Model.Discount;
import com.example.Medicine.Repository.DiscountRepository;
import com.example.Medicine.dto.DiscountRequest;
import com.example.Medicine.dto.DiscountResponse;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository repository;

    @Override
    public DiscountResponse findById(Integer id) {
        Discount entity = repository.getDiscountById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discount not found: " + id));
        return DiscountMapper.toResponse(entity);
    }

    @Override
    public DiscountResponse create(DiscountRequest request) {
        Discount saved = repository.save(DiscountMapper.toEntity(request));
        return DiscountMapper.toResponse(saved);
    }

    @Override
    public DiscountResponse update(Integer id, DiscountRequest request) {
        Discount existing = repository.getDiscountById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discount not found: " + id));

        DiscountMapper.copyToEntity(request, existing);
        Discount saved = repository.save(existing);
        return DiscountMapper.toResponse(saved);
    }
}
