package com.example.apisigep.apisigep.repositories;

import com.example.apisigep.apisigep.models.Factory;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IFactoryRepository extends CrudRepository<Factory, Long> {
    ArrayList<Factory> findAll();
}
