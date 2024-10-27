package com.loan;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
@Deployment(resources = "classpath:loan_approval.bpmn")
public class LoanApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}
}