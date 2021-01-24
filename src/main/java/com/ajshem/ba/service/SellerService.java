package com.ajshem.ba.service;

import com.ajshem.ba.domain.Seller;
import com.ajshem.ba.repo.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SellerService {
    private SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository=sellerRepository;
    }

    public Seller createSeller(String sellerName){
        return sellerRepository.save(new Seller(sellerName));
    }
    public long total(){
        return sellerRepository.count();
    }
}
