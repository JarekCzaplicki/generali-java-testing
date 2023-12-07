package zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCarRepository implements CarRepository {
    private List<Car> cars;

    public InMemoryCarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Optional<Car> findById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }
}

