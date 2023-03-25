package com.example.apisigep.apisigep.repositories;

import com.example.apisigep.apisigep.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IProductRepository extends CrudRepository<Product, Long> {
    ArrayList<Product> findAll();
}
