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

import com.example.Medicine.Service.InvoiceService;
import com.example.Medicine.dto.InvoiceRequest;
import com.example.Medicine.dto.InvoiceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/invoices")
@Tag(name = "Invoices", description = "Management of invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get invoice by ID")
    @ApiResponse(responseCode = "200", description = "Invoice found", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = InvoiceResponse.class))})
    public InvoiceResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new invoice")
    public ResponseEntity<InvoiceResponse> create(@Valid @RequestBody InvoiceRequest req) {
        InvoiceResponse created = service.create(req);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing invoice")
    public InvoiceResponse update(@PathVariable Integer id, @Valid @RequestBody InvoiceRequest req) {
        return service.update(id, req);
    }

    @Operation(summary = "Get invoices by number")
    @GetMapping("/search/{number}")
    public List<InvoiceResponse> getInvoicesByNumber(@PathVariable String number) {
        return service.getInvoiceByNumber(number);
    }

    @Operation(summary = "Get invoices by ID")
    @GetMapping("/search/id/{id}")
    public List<InvoiceResponse> getInvoicesById(@PathVariable Integer id) {
        return service.getInvoiceById(id);
    }
}
