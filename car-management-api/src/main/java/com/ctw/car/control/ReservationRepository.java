package com.ctw.car.control;

import com.ctw.car.entity.Reservation;
import com.ctw.car.entity.ReservationEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Dependent
public class ReservationRepository implements PanacheRepository<ReservationEntity> {
    public List<Reservation> fetchAllReservations() {
        return listAll()
                .stream()
                .map(ReservationEntity::toReservation)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Reservation> fetchReservationsByCarId(UUID car_Uuid) {
        return list("car_id", car_Uuid)
                .stream()
                .map(ReservationEntity::toReservation)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
