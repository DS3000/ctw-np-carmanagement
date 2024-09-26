package com.ctw.car.control;

import com.ctw.car.entity.Car;
import com.ctw.car.entity.EngineType;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

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
}
