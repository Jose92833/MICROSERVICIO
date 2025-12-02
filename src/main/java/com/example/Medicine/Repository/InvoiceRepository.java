package com.example.Medicine.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Medicine.Model.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT * FROM invoices WHERE invoice_id = :id", nativeQuery = true)
    Optional<Invoice> getInvoiceById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM invoices WHERE LOWER(invoice_number) LIKE LOWER(CONCAT('%', :number, '%'))", nativeQuery = true)
    List<Invoice> getInvoicesByNumber(@Param("number") String number);

}
