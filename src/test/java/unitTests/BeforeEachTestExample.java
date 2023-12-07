package unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeEachTestExample {
    @BeforeEach
    void setUp(){
        System.out.println("Ten komunikat wyświetli się przed wykonaniem każdej z metod testowych");
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
