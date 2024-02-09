package com.loan.emi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emies")
public class Emi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private double loanValue;

    @Column
    private double yearlyInterestRate;

    @Column
    private int loanTerm;

    @Column
    private String email;

    @Column
    private double result;

    public Emi() {
    }

    public Emi(double loanValue, double yearlyInterestRate, int loanTerm, String email, Double result) {
        this.loanValue = loanValue;
        this.yearlyInterestRate = yearlyInterestRate;
        this.loanTerm = loanTerm;
        this.email = email;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public double getLoanValue() {
        return loanValue;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public String getEmail() {
        return email;
    }

    public double getResult() {
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLoanValue(double loanValue) {
        this.loanValue = loanValue;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
