package zadania;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AnimalServiceWithoutMockTest {
    private AnimalRepository animalRepository;
    private AnimalService animalService;
    private Long id;
    private String type;

    @BeforeEach
    void setUp(){
        animalRepository = new InMemmoryAnimalRepository();
        animalService = new AnimalService(animalRepository);
    }

    @Test
    void givenAnimalAnimal_whenGetAnimalByIdAndType_ThenVerifyTrue() {
        // given
        id = 1L;
        type = "Dog";
        Animal expected = new Animal(id, type);
        animalService.createAnimal(expected);

        // when
        Animal actual = animalService.getAnimalByIdAndType(id, type);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void givenAnimal_whenSave_ThenVerifyTrue() {
        // given
        Animal expected = new Animal();
        expected.setType("Cat");

        // when
        Animal actual = animalService.createAnimal(expected);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void givenAnimalList_whenGetAllAnimals_ThenVerifyTrue() {
        // given
        Animal animal1 = new Animal(1L, "Dog");
        Animal animal2 = new Animal(2L, "Cat");
        List<Animal> expected = Arrays.asList(animal1, animal2);
        animalService.createAnimal(animal1);
        animalService.createAnimal(animal2);

        // when
        List<Animal> actual = animalService.getAllAnimals();

        // then
        assertEquals(expected, actual);
    }
}
