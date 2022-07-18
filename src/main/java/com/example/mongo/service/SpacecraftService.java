package com.example.mongo.service;

import com.example.mongo.model.Spacecraft;
import com.example.mongo.utils.Response;

import java.util.List;

public interface SpacecraftService {
    List<Spacecraft> findAll();

    Response findById(String id);

    Response save(Spacecraft spacecraft);

    List<Spacecraft> findAllByType(String type);

    Response update(Spacecraft spacecraft);

    Response delete(String id);

}
