package com.example.mongo.factory;

import com.example.mongo.model.Spacecraft;
import com.example.mongo.utils.Response;

public interface Objects {

    default Response createResponseSuccess(Object message) {
        return Response.builder()
                .state(true)
                .message("OK")
                .codeMessage(201)
                .messageBody(message)
                .build();
    }

    default Response createResponseFailed(Object message) {
        return Response.builder()
                .state(false)
                .message("Not found")
                .codeMessage(404)
                .messageBody(message)
                .build();
    }

    default Spacecraft createShipTypeShuttle(Spacecraft spacecraft){
        return Spacecraft.builder()
                .id(spacecraft.getId())
                .name(spacecraft.getName())
                .responsible(spacecraft.getResponsible())
                .type(spacecraft.getType())
                .country("Colombia")
                .year("2022")
                .speed(800)
                .weight(1000)
                .isShuttle(true)
                .build();
    }

    default Spacecraft createUnmannedShip(Spacecraft spacecraft){
        return Spacecraft.builder()
                .id(spacecraft.getId())
                .name(spacecraft.getName())
                .responsible(spacecraft.getResponsible())
                .type(spacecraft.getType())
                .country("Colombia")
                .year("2022")
                .speed(35)
                .weight(200)
                .isShuttle(false)
                .build();
    }

    default Spacecraft createMannedShip(Spacecraft spacecraft){
        return Spacecraft.builder()
                .id(spacecraft.getId())
                .name(spacecraft.getName())
                .responsible(spacecraft.getResponsible())
                .type(spacecraft.getType())
                .country("Colombia")
                .year("2022")
                .speed(400)
                .weight(500)
                .isShuttle(false)
                .build();
    }

}
