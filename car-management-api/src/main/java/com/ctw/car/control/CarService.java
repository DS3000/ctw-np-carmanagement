package com.ctw.car.control;

import com.ctw.car.entity.Car;
import com.ctw.car.entity.EngineType;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;

@ApplicationScoped
public class CarService {
    private final Map<UUID, Car> cars = new HashMap<>();

    private CarService() {
        // Populate initially to have some values, TO BE REMOVED
        UUID id = UUID.randomUUID();
        cars.put(id, new Car(id, "BMW", "3-series", EngineType.PHEV));
        id = UUID.randomUUID();
        cars.put(id, new Car(id, "BMW", "4-series", EngineType.DIESEL));
        id = UUID.randomUUID();
        cars.put(id, new Car(id, "Rolls-Royce", "Spectre", EngineType.BEV));
    }

    public List<Car> getCars() {
        return cars.values().stream().toList();
    }

    public Car createCar(Car car) {
        car.setId(UUID.randomUUID());
        cars.put(car.getId(), car);
        return car;
    }

    public void deleteCar(UUID id) {
        cars.remove(id);
    }

    public Car getCar(UUID id) {
        return cars.get(id);
    }

    public Car updateCar(UUID id, Car car) {
        Car result = null;
        if (Objects.nonNull(car) && Objects.nonNull(id) && cars.containsKey(id)) {
            result = cars.put(id, car);
        }

        return result;
    }
}
