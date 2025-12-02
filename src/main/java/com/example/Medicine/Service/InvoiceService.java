package com.example.Medicine.Service;


import java.util.List;

import com.example.Medicine.dto.InvoiceRequest;
import com.example.Medicine.dto.InvoiceResponse;

public interface InvoiceService {

    InvoiceResponse findById(Integer id);

    InvoiceResponse create(InvoiceRequest req);

    InvoiceResponse update(Integer id, InvoiceRequest req);

    public List<InvoiceResponse> getInvoiceById(Integer id);

    public List<InvoiceResponse> getInvoiceByNumber(String number);

}