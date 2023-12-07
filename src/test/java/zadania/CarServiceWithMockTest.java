package zadania;
// Napisz serwis samochodowy, który będzie miał tylko die metody
// Car getCarById(Long id);
// Car createCar(Car car);
// napisz klasę car napisz repozytorium, napisz implementacje repozytorium oraz testy z użyciem Mock i bez mock


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CarServiceWithMockTest {

    private CarRepository carRepositoryMock;

    private CarService carService;

    @BeforeEach
    public void setup() {
        carRepositoryMock = mock(CarRepository.class);
        carService = new CarService(carRepositoryMock);
    }

    @DisplayName("Test for retrieving car by ID")
    @Test
    public void givenCarId_whenGetCarById_thenReturnCar() {
        // given
        Long carId = 1L;
        Car expectedCar = new Car(carId, "Toyota", "Corolla");
        given(carRepositoryMock.findById(carId)).willReturn(Optional.of(expectedCar));

        // when
        Car foundCar = carService.getCarById(carId).get();

        // then
        assertEquals(expectedCar, foundCar);
    }

    @DisplayName("Test for saving a car")
    @Test
    public void givenNewCar_whenSaveCar_thenReturnSavedCar() {
        // given
        Car newCar = new Car(2L, "Honda", "Civic");
        given(carRepositoryMock.save(any(Car.class))).willReturn(newCar);

        // when
        Car savedCar = carService.createCar(newCar);

        // then
        assertEquals(newCar, savedCar);
    }

    @DisplayName("Test for retrieving all cars")
    @Test
    public void givenExistingCars_whenGetAllCars_thenReturnCarsList() {
        // given
        List<Car> cars = Arrays.asList(new Car(1L, "Toyota", "Corolla"), new Car(2L, "Honda", "Civic"), new Car(3L, "Ford", "Focus"));
        given(carRepositoryMock.findAll()).willReturn(cars);

        // when
        List<Car> allCars = carService.getAllCars();

        // then
        assertEquals(cars.size(), allCars.size());
        assertEquals(cars, allCars);
    }
}
