package com.ajshem.ba.repo;

import java.util.Optional;

import com.ajshem.ba.domain.Buyer;

import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<Buyer, Integer> {
    Optional<Buyer> findByName(String name);
}

