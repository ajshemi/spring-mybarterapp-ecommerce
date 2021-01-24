package com.ajshem.ba.service;

import com.ajshem.ba.domain.Product;
import com.ajshem.ba.domain.Seller;
import com.ajshem.ba.repo.ProductRepository;
import com.ajshem.ba.repo.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    private ProductRepository productRepository;
    private SellerRepository sellerRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,SellerRepository sellerRepository){
        this.productRepository=productRepository;
        this.sellerRepository=sellerRepository;
    }

    public Product createProduct(String name, String sellerName){
        Seller seller = sellerRepository.findByName(sellerName).orElseThrow(()-> new RuntimeException("Seller does not exist " + sellerName ));
        return productRepository.save(new Product(name,seller));
    }
    public long total(){
        return productRepository.count();
    }
}
