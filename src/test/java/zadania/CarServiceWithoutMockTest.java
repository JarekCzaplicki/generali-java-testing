package zadania;
// Napisz serwis samochodowy, który będzie miał tylko die metody
// Car getCarById(Long id);
// Car createCar(Car car);
// napisz klasę car napisz repozytorium, napisz implementacje repozytorium oraz testy z użyciem Mock i bez mock

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarServiceWithoutMockTest {
    private CarRepository carRepository;
    private CarService carService;
    @BeforeEach
    void setUp(){
         carRepository = new InMemoryCarRepository();
         carService = new CarService(carRepository);
    }
    @Test
    public void givenCarId_whenGetCarById_thenCarReturned() {

        Car car = new Car(1L, "Toyota", "Camry");
        carRepository.save(car);

        Car foundCar = carService.getCarById(1L).get();

        assertNotNull(foundCar);
        assertEquals("Toyota", foundCar.getMake());
        assertEquals("Camry", foundCar.getModel());
    }

    @Test
    public void givenCar_whenCreateCar_thenCarCreated() {
        Car car = new Car(1L, "Toyota", "Camry");
        Car savedCar = carService.createCar(car);

        assertNotNull(savedCar);
        assertEquals("Toyota", savedCar.getMake());
        assertEquals("Camry", savedCar.getModel());
    }
}
