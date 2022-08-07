package com.tech.fileupload.assignmet.repository;

import com.tech.fileupload.assignmet.entity.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {
    InvoiceDetails findByInvoiceNo(String invoiceNo);
}
