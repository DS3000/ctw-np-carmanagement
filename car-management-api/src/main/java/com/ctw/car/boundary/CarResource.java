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
import java.util.UUID;

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

    @GET
    @Path("{carId}")
    public Response getCarById(
            String carId
    ) {
        UUID car_uuid = UUID.fromString(carId);

        var found_car = this.carService.getCarById(car_uuid);
        if (found_car.isEmpty()){
            return Response.status(400, "Could not fetch car info. Reason: car not found").build();
        }
        return Response.status(200).entity(found_car.get()).build();
    }

    @DELETE
    @Path("{carId}")
    public Response deleteCarById(
        String carId
    ) {
        UUID car_uuid = UUID.fromString(carId);        

        var removed_entries = this.carService.deleteCarById(car_uuid);
        if (removed_entries == 0) {
            return Response.status(400, "Could not delete car. Reason: car not found.").build();
        }

        return Response.status(200).build();
    }
}
