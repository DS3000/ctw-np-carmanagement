package com.ctw.car.boundary;

import com.ctw.car.control.CarService;
import com.ctw.car.entity.Car;
import com.ctw.car.entity.Routes;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path(Routes.CAR)
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource(final CarService carService) {
        this.carService = carService;
    }

    @GET
    public Response getCars(
            @QueryParam("brand") String brand
    ) {
        List<Car> cars = this.carService.getCars();
        return Response.status(200).entity(cars).build();
    }
}
