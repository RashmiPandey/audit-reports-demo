package com.reports.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AuditReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditReportsApplication.class, args);
	}

}
