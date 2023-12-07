package zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryAnimalRepository implements AnimalRepository {

    private final List<Animal> animals = new ArrayList<>();
    private long nextId = 1;

    @Override
    public Optional<Animal> findByIdAndType(Long id, String type) {
        return animals.stream()
                .filter(animal -> animal.getId().equals(id) && animal.getType().equals(type))
                .findFirst();
    }

    @Override
    public Animal save(Animal animal) {
        if (animal.getId() == null) {
            animal.setId(nextId++);
            animals.add(animal);
        } else if (animal.getId() != null) animals.add(animal);
        else {
            int index = findAnimalIndexById(animal.getId());
            if (index != -1) {
                animals.set(index, animal);
            } else {
                throw new IllegalArgumentException("Animal with given ID not found: " + animal.getId());
            }
        }
        return animal;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animals;
    }

    private int findAnimalIndexById(Long id) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
