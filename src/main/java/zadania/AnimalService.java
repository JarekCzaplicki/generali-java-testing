package zadania;

import java.util.List;
import java.util.Optional;

public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {

        this.animalRepository = animalRepository;
    }

    public Animal getAnimalByIdAndType(Long id, String type){
        return animalRepository.findByIdAndType(id, type).get();
    }
    public Animal createAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals(){
        return animalRepository.getAllAnimals();
    }

}
