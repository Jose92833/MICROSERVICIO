package com.example.Medicine.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Medicine.Service.DiscountService;
import com.example.Medicine.dto.DiscountRequest;
import com.example.Medicine.dto.DiscountResponse;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/discounts")
@Tag(name = "Discounts", description = "Management of discounts")
@RequiredArgsConstructor

public class DiscountController {

    private final DiscountService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get discount by ID")
    @ApiResponse(responseCode = "200", description = "Discount found", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = DiscountResponse.class))})
    public DiscountResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new discount")
    public ResponseEntity<DiscountResponse> create(@Valid @RequestBody DiscountRequest req) {
        DiscountResponse created = service.create(req);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing discount")
    public DiscountResponse update(@PathVariable Integer id, @Valid @RequestBody DiscountRequest req) {
        return service.update(id, req);
    }
}
