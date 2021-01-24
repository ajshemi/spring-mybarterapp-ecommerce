package com.ajshem.ba.service;

import com.ajshem.ba.domain.Buyer;
import com.ajshem.ba.repo.BuyerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BuyerService {
    private BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository=buyerRepository;
    }

    public Buyer createBuyer(String buyerName){
        return buyerRepository.save(new Buyer(buyerName));
    }
    public long total(){
        return buyerRepository.count();
    }
}
