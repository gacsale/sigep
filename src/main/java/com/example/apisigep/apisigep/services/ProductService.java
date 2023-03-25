package com.example.apisigep.apisigep.services;

import com.example.apisigep.apisigep.models.Factory;
import com.example.apisigep.apisigep.models.Product;
import com.example.apisigep.apisigep.repositories.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepo;
    @Override
//    @Transactional(readOnly = true)
    public ArrayList<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product get(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }

        return product.get();
    }

    @Override
    public void create(Product data) {
        try {
            productRepo.save(data);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public void update(Product data, Long id) {
        Product curProduct = this.get(id);
        try {
            curProduct.setName(data.getName());
            curProduct.setPrice(data.getPrice());
            productRepo.save(curProduct);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public void remove(Long id) {
        Product curProduct = this.get(id);
        try {
            productRepo.delete(curProduct);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
