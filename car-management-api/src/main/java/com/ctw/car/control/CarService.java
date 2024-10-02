package com.ctw.car.control;

import com.ctw.car.entity.Car;
import com.ctw.car.entity.EngineType;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Dependent
public class CarService {
    private final CarRepository carRepository;

    @Inject
    public CarService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.fetchAllCars();
    }

    public Optional<Car> getCarById(UUID uuid) {
        return carRepository.fetchCarById(uuid);
    }

    public long deleteCarById(UUID uuid) {
        var removed_entries = this.carRepository.deleteCarById(uuid);
        return removed_entries;
    }
}
