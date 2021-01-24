package com.ajshem.ba.repo;

import com.ajshem.ba.domain.Transaction;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}