package com.loan.emi;

import com.loan.emi.service.EmiService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateEmiServiceTest {
    @Test
    public void testCalculateEmi() {
        EmiService service = new EmiService();

        double loanValue = 10000.0;
        double yearlyInterestRate = 5.0;
        int loanTerm = 2;

        double expectedEmi = 4167.642703644296; // Calculated using a loan EMI calculator

        double emi = service.calculateEmi(loanValue, yearlyInterestRate, loanTerm);

        Assertions.assertEquals(expectedEmi, emi, 0.01);
    }
}
