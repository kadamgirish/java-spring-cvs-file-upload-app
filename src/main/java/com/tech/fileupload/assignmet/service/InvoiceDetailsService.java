package com.tech.fileupload.assignmet.service;

import com.tech.fileupload.assignmet.entity.InvoiceDetails;
import com.tech.fileupload.assignmet.repository.InvoiceDetailsRepository;
import com.tech.fileupload.assignmet.utils.CSVFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public void save(MultipartFile file) {
        try {
            List<InvoiceDetails> tutorials = CSVFileReader.csvToInvoiceDetails(file.getInputStream());
            invoiceDetailsRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public Page<InvoiceDetails> getInvoiceDetails(Pageable pageable) {
        return invoiceDetailsRepository.findAll(pageable);
    }

    public InvoiceDetails findByInvoiceNo(String invoiceNo) {
        return invoiceDetailsRepository.findByInvoiceNo(invoiceNo);
    }

}
