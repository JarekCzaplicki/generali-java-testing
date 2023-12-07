package zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemmoryAnimalRepository implements AnimalRepository {
    private final List<Animal> animals = new ArrayList<>();
    private Long nexId = 1L;

    @Override
    public Optional<Animal> findByIdAndType(Long id, String type) {
        return animals.stream()
                .filter(animal -> animal.getId().equals(id) && animal.getType().equals(type))
                .findFirst();
    }

    @Override
    public Animal save(Animal animal) {
        if (animal.getId() == null) {
            animal.setId(nexId++);
            animals.add(animal);
            return animal;
        } else {
            boolean isPresent = findAnimalById(animal.getId());
            if (isPresent)
                throw new IllegalArgumentException("Animal with given id already exist in database " + animal.getId());
            animals.add(animal);
            return animal;
        }
    }

    private boolean findAnimalById(Long id) {
        for (Animal animal : animals) {
            if (animal.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animals;
    }
}
