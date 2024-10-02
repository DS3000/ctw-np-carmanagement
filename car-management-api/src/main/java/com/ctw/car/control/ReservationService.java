package com.ctw.car.control;

import com.ctw.car.entity.Reservation;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Dependent
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Inject
    public ReservationService(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.fetchAllReservations();
    }

    public List<Reservation> getReservationsByCarId(UUID car_Uuid){
        return reservationRepository.fetchReservationsByCarId(car_Uuid);
    }
}
