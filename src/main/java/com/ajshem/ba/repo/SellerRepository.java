package com.ajshem.ba.repo;

import java.util.Optional;

import com.ajshem.ba.domain.Seller;

import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer> {
    Optional<Seller> findByName(String name);
}




