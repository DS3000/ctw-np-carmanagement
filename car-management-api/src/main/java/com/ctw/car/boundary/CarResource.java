package com.ctw.car.boundary;

import com.ctw.car.control.CarService;
import com.ctw.car.entity.Car;
import com.ctw.car.entity.Routes;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
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
    @Path("/{id}")
    public Response getCars(
            @PathParam("id") UUID id
    ) {
        Car car = this.carService.getCar(id);

        if(car != null) {
            return Response.status(200).entity(car).build();
        } else{
            return Response.status(404).build();
        }
    }

    @POST
    public Response createCar(@Valid Car car) {
        Car newCar = carService.createCar(car);

        return Response
                .created(URI.create(Routes.CAR + "/" + newCar.getId()))
                .entity(newCar)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCar(@PathParam("id") UUID id, @Valid Car car) {
        Car updatedCar = carService.updateCar(id, car);

        return Response
                .created(URI.create(Routes.CAR + "/" + updatedCar.getId()))
                .entity(updatedCar)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") UUID id) {
        carService.deleteCar(id);
        return Response.ok().build();
    }
}
