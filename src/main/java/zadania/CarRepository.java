package zadania;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Optional<Car> findById(Long id);
    Car save(Car car);
    List<Car> findAll();
}
