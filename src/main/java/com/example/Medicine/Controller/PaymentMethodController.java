package com.example.Medicine.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Medicine.Service.PaymentMethodService;
import com.example.Medicine.dto.PaymentMethodRequest;
import com.example.Medicine.dto.PaymentMethodResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payment_methods")
@Tag(name = "Payment Methods", description = "Management of payment methods")
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get payment method by ID")
    @ApiResponse(responseCode = "200", description = "Payment method found", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentMethodResponse.class))})
    public PaymentMethodResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new payment method")
    public ResponseEntity<PaymentMethodResponse> create(@Valid @RequestBody PaymentMethodRequest req) {
        PaymentMethodResponse created = service.create(req);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing payment method")
    public PaymentMethodResponse update(@PathVariable Integer id, @Valid @RequestBody PaymentMethodRequest req) {
        return service.update(id, req);
    }

    @Operation(summary = "Get payment methods by name")
    @GetMapping("/search/{name}")
    public List<PaymentMethodResponse> getPaymentMethodsByName(@PathVariable String name) {
        return service.getPaymentMethodByName(name);
    }
}

