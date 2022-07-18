package com.example.mongo.service;

import com.example.mongo.factory.Objects;
import com.example.mongo.model.Spacecraft;
import com.example.mongo.repository.SpacecraftRepository;
import com.example.mongo.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SpacecraftServiceImpl implements SpacecraftService, Objects {

    SpacecraftRepository spacecraftRepository;

    @Override
    public List<Spacecraft> findAll() {
        return spacecraftRepository.findAll();
    }

    @Override
    public Response findById(String id) {
        if (spacecraftRepository.existsById(id)) {
            return createResponseSuccess(spacecraftRepository.findById(id));
        } else {
            return createResponseFailed("La identificacion de la nave que desea consultar no existe en la DB");
        }
    }

    @Override
    public Response save(Spacecraft spacecraft) {
        Spacecraft ship = validateType(spacecraft);
        if (spacecraftRepository.existsById(spacecraft.getId())) {
            return createResponseFailed("La identificacion de la nave ya se encuentra registrada");
        } else if (ship != null) {
            return createResponseSuccess(spacecraftRepository.save(ship));
        } else {
            return createResponseFailed("El tipo de nave ingresado no existe");
        }
    }

    Spacecraft validateType(Spacecraft spacecraft) {
        Spacecraft ship = null;
        if ("Shuttle".equals(spacecraft.getType())) {
            ship = createShipTypeShuttle(spacecraft);
        } else if ("UnmannedShip".equals(spacecraft.getType())) {
            ship = createUnmannedShip(spacecraft);
        } else if ("MannedShip".equals(spacecraft.getType())) {
            ship = createMannedShip(spacecraft);
        }
        return ship;
    }

    @Override
    public List<Spacecraft> findAllByType(String type) {
        return spacecraftRepository.findAll().stream()
                .filter(spacecraft -> type.equals(spacecraft.getType()))
                .collect(Collectors.toList());
    }

    @Override
    public Response update(Spacecraft spacecraft) {
        Spacecraft ship = validateType(spacecraft);
        if (spacecraftRepository.existsById(spacecraft.getId()) && ship != null) {
            return createResponseSuccess(spacecraftRepository.save(ship));
        } else {
            return createResponseFailed("La nave que desea actualizar no existe o no cumple con las validaciones del tipo de nave");
        }
    }

    @Override
    public Response delete(String id) {
        if (spacecraftRepository.existsById(id)) {
            spacecraftRepository.deleteById(id);
            return createResponseSuccess("La nave " + id + " se elimino con exito");
        } else {
            return createResponseFailed("El id que desea eliminar no existe");
        }
    }

}
