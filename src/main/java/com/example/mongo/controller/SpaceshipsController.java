package com.example.mongo.controller;

import com.example.mongo.model.Spacecraft;
import com.example.mongo.service.SpacecraftService;
import com.example.mongo.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SpaceshipsController {
    private final SpacecraftService spacecraftService;

    @GetMapping("/simple")
    public List<Spacecraft> getSimple() {
        return spacecraftService.findAll();
    }

    @GetMapping("/id/{id}")
    public Response getDetailById(@PathVariable(value = "id") String id) {
        return spacecraftService.findById(id);
    }

    @GetMapping("/type/{type}")
    public List<Spacecraft> getAllByType(@PathVariable(value = "type") String type) {
        return spacecraftService.findAllByType(type);
    }

    @PostMapping("/add")
    public Response saveSpacecraft(@RequestBody Spacecraft spacecraft) {
        return spacecraftService.save(spacecraft);
    }

    @PostMapping("/update")
    public Response updateSpacecraft(@RequestBody Spacecraft spacecraft) {
        return spacecraftService.update(spacecraft);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteSpacecraft(@PathVariable(value = "id") String id) {
        return spacecraftService.delete(id);
    }
}
