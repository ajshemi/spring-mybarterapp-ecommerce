package com.ajshem.ba.service;

import com.ajshem.ba.domain.Buyer;
import com.ajshem.ba.domain.Product;
import com.ajshem.ba.domain.Transaction;
import com.ajshem.ba.repo.BuyerRepository;
import com.ajshem.ba.repo.ProductRepository;
import com.ajshem.ba.repo.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;
    private BuyerRepository buyerRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ProductRepository productRepository, BuyerRepository buyerRepository){
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.buyerRepository = buyerRepository;
    }

    public Transaction createTransaction(String productName, String buyerName){
        Product product = productRepository.findByName(productName).orElseThrow(()-> new RuntimeException("Product does not exist " + productName));
        Buyer buyer = buyerRepository.findByName(buyerName).orElseThrow(()-> new RuntimeException("Buyer does not exist " + buyerName));

        return transactionRepository.save(new Transaction(product,buyer));
    }

    public Iterable<Transaction> lookup(){
        return transactionRepository.findAll();
    }

    public long total(){
        return transactionRepository.count();
    }
    
}
