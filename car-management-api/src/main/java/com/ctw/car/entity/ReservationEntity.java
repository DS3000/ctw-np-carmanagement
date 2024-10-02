package com.ctw.car.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "T_RESERVATION")
public class ReservationEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    public UUID id;

    @Column(name = "CAR_ID", nullable = false)
    public UUID car_id;

    @Column(name = "PICK_UP", nullable = false)
    public LocalDateTime pick_up;

    @Column(name = "DROP_OFF", nullable = false)
    public LocalDateTime drop_off;

    @Column(name = "RESERVE_NAME", nullable = false)
    public String reserve_name;

    @Column(name = "CONTACT", nullable = false)
    public String contact;

    @Column(name = "LICENSE", nullable = false)
    public String license;

    public static Reservation toReservation(ReservationEntity reservationEntity) {
        if (Objects.nonNull(reservationEntity)) {
            return new Reservation(
                reservationEntity.id,
                reservationEntity.car_id,
                reservationEntity.pick_up,
                reservationEntity.drop_off,
                reservationEntity.reserve_name,
                reservationEntity.contact,
                reservationEntity.license
            );
        }
        return null;
    }
}
