package com.example.apisigep.apisigep.controllers;

import com.example.apisigep.apisigep.models.Factory;
import com.example.apisigep.apisigep.models.Product;
import com.example.apisigep.apisigep.services.IProductService;
import com.example.apisigep.apisigep.tools.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private IProductService productSrv;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        ArrayList<Product> categories = productSrv.getAll();
        return ApiResponse.success(categories);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> get(@PathVariable Long productId) {
        return ApiResponse.success(productSrv.get(productId));
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse> create(@RequestBody Product data) {
        productSrv.create(data);
        return ApiResponse.success(data, "Datos almacenados correctamente");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse> update(@RequestBody Product data, @PathVariable Long productId) {
        productSrv.update(data, productId);
        return ApiResponse.success(data, "Datos actualizados correctamente");
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> remove(@PathVariable Long productId) {
        productSrv.remove(productId);
        return ApiResponse.success(null, "Eliminado correctamente");
    }

}