package com.example.apisigep.apisigep.controllers;

import com.example.apisigep.apisigep.models.Factory;
import com.example.apisigep.apisigep.services.IFactoryService;
import com.example.apisigep.apisigep.tools.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@RestController
@RequestMapping("api/factory")
public class FactoryController {
    @Autowired
    private IFactoryService factorySrv;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAll() {
        ArrayList<Factory> categories = factorySrv.getAll();
        return ApiResponse.success(categories);
    }

    @GetMapping("/{factoryId}")
    public ResponseEntity<ApiResponse> get(@PathVariable Long factoryId) {
        return ApiResponse.success(factorySrv.get(factoryId));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> create(@RequestBody Factory data) {
        factorySrv.create(data);
        return ApiResponse.success(data, "Datos almacenados correctamente");
    }

    @PutMapping("/{factoryId}")
    public ResponseEntity<ApiResponse> update(@RequestBody Factory data, @PathVariable Long factoryId) {
        factorySrv.update(data, factoryId);
        return ApiResponse.success(data, "Datos actualizados correctamente");
    }

    @DeleteMapping("/{factoryId}")
    public ResponseEntity<ApiResponse> remove(@PathVariable Long factoryId) {
        factorySrv.remove(factoryId);
        return ApiResponse.success(null, "Eliminado correctamente");
    }



}