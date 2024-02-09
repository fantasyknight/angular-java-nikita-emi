package com.loan.emi.payload;

import jakarta.validation.constraints.*;

public class CreateEmiRequest {

    @Positive(message = "Loan value must be a positive number")
    private double loanValue;

    @Min(value = 0, message = "Yearly interest rate must be a positive number")
    @Max(value = 100, message = "Yearly interest rate must be between 0 and 100")
    private double yearlyInterestRate;

    @Min(value = 0, message = "Loan term must be a positive number")
    @Max(value = 30, message = "Loan term must be between 0 and 30")
    private int loanTerm;

    @Email(message = "Invalid email address")
    private String email;


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
}
