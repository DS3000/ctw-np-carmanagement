package com.ctw.car.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private UUID car_id;
    private LocalDateTime pick_up;
    private LocalDateTime drop_off;
    private String reserve_name;
    private String contact;
    private String license;

    public Reservation() {

    }

    public Reservation(UUID id, UUID car_id, LocalDateTime pick_up, LocalDateTime drop_off, String reserve_name,
            String contact, String license) {
        this.id = id;
        this.car_id = car_id;
        this.pick_up = pick_up;
        this.drop_off = drop_off;
        this.reserve_name = reserve_name;
        this.contact = contact;
        this.license = license;

    }

    public UUID getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public UUID getCar_id() {
        return car_id;
    }

    public LocalDateTime getPick_up() {
        return pick_up;
    }

    public LocalDateTime getDrop_off() {
        return drop_off;
    }

    public String getReserve_name() {
        return reserve_name;
    }

    public String getLicense() {
        return license;
    }
}
