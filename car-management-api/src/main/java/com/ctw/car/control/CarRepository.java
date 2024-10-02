package com.ctw.car.control;

import com.ctw.car.entity.Car;
import com.ctw.car.entity.CarEntity;
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
public class CarRepository implements PanacheRepository<CarEntity> {
    public List<Car> fetchAllCars() {
        return listAll()
                .stream()
                .map(CarEntity::toCar)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public long deleteCarById(UUID uuid) {
        var removed_entries = this.delete("id", uuid);
        return removed_entries;
    }

    public Optional<Car> fetchCarById(UUID uuid) {
        var carEntity = find("id", uuid).firstResultOptional();
        if (carEntity.isPresent()){
            var car = CarEntity.toCar(carEntity.get());
            return Optional.of(car);
        }

        return Optional.empty();        
    }
}
