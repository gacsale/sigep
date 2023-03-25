package com.example.apisigep.apisigep.services;

import com.example.apisigep.apisigep.models.Factory;
import com.example.apisigep.apisigep.models.Product;

import java.util.ArrayList;

public interface IProductService {
    public ArrayList<Product> getAll();
    public Product get(Long id);
    public void create(Product data);
    public void update(Product data, Long id);
    public void remove(Long id);
}
