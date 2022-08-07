package com.tech.fileupload.assignmet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class CsvFileUploadAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvFileUploadAssignmentApplication.class, args);
		System.out.println("file upload app started");
	}

}
