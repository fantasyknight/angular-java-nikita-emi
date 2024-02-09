package com.loan.emi.controller;

import com.loan.emi.model.Emi;
import com.loan.emi.payload.CreateEmiRequest;
import com.loan.emi.repository.EmiRepository;
import com.loan.emi.service.EmiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmiController {
    @Autowired
    EmiRepository emiRepository;

    @Autowired
    EmiService emiService;

    @GetMapping("/")
    public ResponseEntity<List<Emi>> getResults() {
        List<Emi> results = new ArrayList<Emi>();
        try {
             emiRepository.findAll().forEach(results::add);

             if (results.isEmpty()) {
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }

            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Double> createEmi(@Valid @RequestBody CreateEmiRequest emiRequest) {
        double result = emiService.calculateEmi(emiRequest.getLoanValue(), emiRequest.getYearlyInterestRate(), emiRequest.getLoanTerm());
        try {
            Emi emi = emiRepository.save(new Emi(emiRequest.getLoanValue(), emiRequest.getYearlyInterestRate(), emiRequest.getLoanTerm(), emiRequest.getEmail(), result));
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
