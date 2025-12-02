package com.example.Medicine.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Medicine.Service.PaymentService;
import com.example.Medicine.dto.PaymentRequest;
import com.example.Medicine.dto.PaymentResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payments")
@Tag(name = "Payments", description = "Management of payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get payment by ID")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new payment")
    public ResponseEntity<PaymentResponse> create(@Valid @RequestBody PaymentRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing payment")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody PaymentRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }
}