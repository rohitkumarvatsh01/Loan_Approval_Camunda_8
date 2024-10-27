package com.loan.entity;

import jakarta.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicant_name", nullable = false)
    private String applicantName;

    @Column(name = "loan_amount", nullable = false)
    private Double loanAmount;

    @Column(name = "credit_score", nullable = false)
    private Integer creditScore;

    public Loan(){
    }

    public Loan(Long id, String applicantName, Double loanAmount, Integer creditScore) {
        this.id = id;
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", applicantName='" + applicantName + '\'' +
                ", loanAmount=" + loanAmount +
                ", creditScore=" + creditScore +
                '}';
    }
}