package com.loan.emi.repository;

import com.loan.emi.model.Emi;
import org.springframework.data.repository.CrudRepository;

public interface EmiRepository extends CrudRepository<Emi, Long> {
}
