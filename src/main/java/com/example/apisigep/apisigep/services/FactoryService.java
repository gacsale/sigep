package com.example.apisigep.apisigep.services;

import com.example.apisigep.apisigep.models.Factory;
import com.example.apisigep.apisigep.repositories.IFactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FactoryService implements IFactoryService {
    @Autowired
    private IFactoryRepository factoryRepo;
    @Override
//    @Transactional(readOnly = true)
    public ArrayList<Factory> getAll() {
        return factoryRepo.findAll();
    }

    @Override
    public Factory get(Long id) {
        Optional<Factory> factory = factoryRepo.findById(id);
        if (!factory.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }

        return factory.get();
    }

    @Override
    public void create(Factory data) {
        try {
            factoryRepo.save(data);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public void update(Factory data, Long id) {
        Factory curFactory = this.get(id);
        try {
            curFactory.setName(data.getName());
            factoryRepo.save(curFactory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public void remove(Long id) {
        Factory curFactory = this.get(id);
        try {
            factoryRepo.delete(curFactory);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
