package com.loan.controller;

import com.loan.entity.Loan;
import com.loan.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<String> checkEligibility(@RequestBody Loan loan) {
        String responseMessage = loanService.checkEligibility(loan);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseMessage);
    }
}