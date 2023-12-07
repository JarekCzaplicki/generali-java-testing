package unitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AfterEachTestExample {
    @AfterEach
    void tearDown(){
        System.out.println("Ten komunikat wyświetli się po wykonaniem każdej z metod testowych");
    }
    @Test
    void firstTest(){
        System.out.println("Wykonuję pierwszy test");
    }

    @Test
    void secondTest(){
        System.out.println("Wykonuję drugi test");
    }
}
