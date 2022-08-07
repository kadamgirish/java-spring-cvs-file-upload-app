package com.tech.fileupload.assignmet.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;
    private String invoiceNo;
    private String stockCode;
    private String description;
    private String invoiceDate;
    private Integer quantity;
    private Double unitPrice;
    private String customerId;
    private String country;
}
