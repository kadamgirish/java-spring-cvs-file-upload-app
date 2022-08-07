package com.tech.fileupload.assignmet.controller;

import com.tech.fileupload.assignmet.entity.InvoiceDetails;
import com.tech.fileupload.assignmet.service.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CSVFileUploadController {
    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @PostMapping("/CSVFileUpload")
    public String FileUpload(@RequestParam("file")MultipartFile file) {
        invoiceDetailsService.save(file);
        return "success";
    }

    @GetMapping("/data/{page}/{size}")
    public Page<InvoiceDetails> getFileData(@PathVariable Integer page, @PathVariable Integer size) {
        return invoiceDetailsService.getInvoiceDetails(PageRequest.of(page, size));
    }

}
