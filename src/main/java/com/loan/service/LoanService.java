package com.loan.service;

import com.loan.entity.Loan;
import com.loan.repository.LoanRepository;
import io.camunda.zeebe.client.ZeebeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoanService {
    private static final Logger logger = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    private ZeebeClient zeebeClient;

    @Autowired
    private LoanRepository loanRepository;

    public String checkEligibility(Loan loan) {
        loanRepository.save(loan);
        logger.info("Loan application saved for applicant: {}", loan.getApplicantName());

        boolean isEligible = loan.getCreditScore() >= 700;
        if (isEligible) {
            logger.info("Applicant {} is eligible for the loan.", loan.getApplicantName());
            initiateLoanApprovalProcess(loan);
            return "Loan application submitted successfully.";
        } else {
            logger.info("Applicant {} is not eligible for the loan.", loan.getApplicantName());
            return "Loan application submitted successfully.";
        }
    }

    private void initiateLoanApprovalProcess(Loan loan) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("applicantName", loan.getApplicantName());
        hashMap.put("loanAmount", loan.getLoanAmount());
        hashMap.put("creditScore", loan.getCreditScore());

        zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId("loan-approval")
                .latestVersion()
                .variables(hashMap)
                .send()
                .join();

        logger.info("Loan approval process started for applicant: {}", loan.getApplicantName());
    }
}