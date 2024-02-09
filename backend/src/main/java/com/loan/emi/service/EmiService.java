package com.loan.emi.service;

import org.springframework.stereotype.Service;

@Service
public class EmiService {
    public double calculateEmi(double loanValue, double yearlyInterestRate, int loanTerm) {
        double monthlyInterestRate = yearlyInterestRate / 12;
        int tenureInMonths = loanTerm * 12;

        return loanValue * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)
                / (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
    }
}
