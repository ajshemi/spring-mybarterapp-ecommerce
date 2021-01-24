package com.ajshem.ba.repo;

import java.util.Optional;

import com.ajshem.ba.domain.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{

    Optional<Product> findByName(String name);


}