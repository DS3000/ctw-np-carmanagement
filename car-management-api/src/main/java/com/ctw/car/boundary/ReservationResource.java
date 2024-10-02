package com.ctw.car.boundary;

import com.ctw.car.control.ReservationService;
import com.ctw.car.control.ReservationService;
import com.ctw.car.entity.Car;
import com.ctw.car.entity.Routes;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path(Routes.RESERVATION)
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservationResource {

    private final ReservationService reservationService;

    @Inject
    public ReservationResource(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GET
    public Response getAllReservations() {
        var reservations = this.reservationService.getAllReservations();
        return Response.status(200).entity(reservations).build();
    }

    @GET
    @Path("{carId}")
    public Response getReservationsByCarId(
            String carId) {
        UUID car_uuid = UUID.fromString(carId);

        var found_reservations = this.reservationService.getReservationsByCarId(car_uuid);
        if (found_reservations.isEmpty()) {
            return Response.status(400, "Could not fetch car info. Reason: car not found").build();
        }
        return Response.status(200).entity(found_reservations).build();
    }
}
