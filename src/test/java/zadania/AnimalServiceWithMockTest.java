package zadania;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//Zadanie 3
//Napisz interfejs 'AnimalRepository' z dwoma metodami:
//- Optional<Animal> findByIdAndType(Long id, String type);
//- Animal save(Animal animal);
//Napisz service 'AnimalService' i wstrzyknij do niego przez konstruktor
//- Animal getAnimalByIdAndType(Long id, String type)
//- Animal createAnimal(Animal animal)
//Napisz testy w 2 wersjach:
//- AnimalServiceWithoutMockTest.java
//- AnimalServiceWithMockTest.java
public class AnimalServiceWithMockTest {
    private AnimalRepository animalRepositoryMock;
    private AnimalService animalService;
    private Long id;
    private String type;

    @BeforeEach
    void setUp(){
        animalRepositoryMock = mock(AnimalRepository.class);
        animalService = new AnimalService(animalRepositoryMock);
    }
    @Test
    void givenAnimalAnimal_whenGetAnimalByIdAndType_ThenVerifyTrue() {
        // given
        id = 1L;
        type = "Dog";
        Animal expected = new Animal(id, type);
        when(animalRepositoryMock.findByIdAndType(id, type)).thenReturn(Optional.of(expected));

        // when
        Animal actual = animalService.getAnimalByIdAndType(id, type);

        // then
        assertEquals(expected, actual);
        verify(animalRepositoryMock, times(1)).findByIdAndType(id, type);
    }

    @Test
    void givenAnimal_whenSave_ThenVerifyTrue() {
        // given
        Animal expected = new Animal();
        expected.setType("Cat");
        when(animalRepositoryMock.save(expected)).thenReturn(expected);

        // when
        Animal actual = animalService.createAnimal(expected);

        // then
        assertEquals(expected, actual);
        verify(animalRepositoryMock, times(1)).save(expected);
    }

    @Test
    void givenAnimalList_whenGetAllAnimals_ThenVerifyTrue() {
        // given
        Animal animal1 = new Animal(1L, "Dog");
        Animal animal2 = new Animal(2L, "Cat");
        List<Animal> expected = Arrays.asList(animal1, animal2);
        when(animalRepositoryMock.getAllAnimals()).thenReturn(expected);

        // when
        List<Animal> actual = animalService.getAllAnimals();

        // then
        assertEquals(expected, actual);
        verify(animalRepositoryMock, times(1)).getAllAnimals();
    }
}
