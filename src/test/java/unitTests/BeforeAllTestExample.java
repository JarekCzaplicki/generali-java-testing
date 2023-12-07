package unitTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeAllTestExample {
    @BeforeAll
    static void setUp(){
        System.out.println("Ten komunikat wyświetli się raz przed wykonaniem wszystkich metod testowych");
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
