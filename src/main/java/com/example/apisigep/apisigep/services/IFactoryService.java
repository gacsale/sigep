package com.example.apisigep.apisigep.services;

import com.example.apisigep.apisigep.models.Factory;

import java.util.ArrayList;

public interface IFactoryService {
    public ArrayList<Factory> getAll();
    public Factory get(Long id);
    public void create(Factory data);
    public void update(Factory data, Long id);
    public void remove(Long id);
}
