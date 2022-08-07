package com.tech.fileupload.assignmet.utils;

import com.tech.fileupload.assignmet.entity.InvoiceDetails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVFileReader {
    public static String TYPE = "text/csv";
    public static List<InvoiceDetails> csvToInvoiceDetails(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<InvoiceDetails> invoiceDetailsList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                InvoiceDetails invoiceDetails = new InvoiceDetails();
                invoiceDetails.setInvoiceNo(csvRecord.get("InvoiceNo"));
                invoiceDetails.setStockCode(csvRecord.get("StockCode"));
                invoiceDetails.setDescription(csvRecord.get("Description"));
                invoiceDetails.setInvoiceDate(csvRecord.get("InvoiceDate"));
                invoiceDetails.setCountry(csvRecord.get("Country"));
                invoiceDetails.setQuantity(Integer.parseInt(csvRecord.get("Quantity")));
                invoiceDetails.setCustomerId(csvRecord.get("CustomerID"));
                invoiceDetails.setUnitPrice(Double.parseDouble(csvRecord.get("UnitPrice")));
                invoiceDetailsList.add(invoiceDetails);
            }
            return invoiceDetailsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
