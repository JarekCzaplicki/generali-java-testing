package zadania;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findByIdAndType(Long id, String type);
    Animal save(Animal animal);
    List<Animal> getAllAnimals();
}
