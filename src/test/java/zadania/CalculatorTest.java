package zadania;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Zadanie 1:
//- Napisz prosty kalkulator
//- napisz metody add, subtract, multiply, divide
//- napisz testy gdzie:
//    - przed każdym testem inicjalizuj nowy obiekt kalkulatora
//    - po każdym teście przypisz do zmiennej wartość null
//- napisz testy dla każdej metody
//    - gdzie do metody add przekazujemy dowolną ilość elementów
//    - metody  multiply, divide otrzymują po 2 elementy
//- jeden test ma zwracać wyjątek w związku z dzieleniem przez 0
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown(){
        calculator = null;
    }
    @Test
    void givenNumbers_WhenAdded_ThenReturnSum(){
        // given
        int a = 5;
        int b = 52;
        int c = 100;
        int d = 500;
        int expected = 657;

         // when
        int actual = calculator.add(a,b,c,d);

        // then
        assertEquals(expected, actual);
    }

//    subtract, multiply, divide
    @Test
    void givenTwoNumbers_WhenSubtract_ThenReturnDifference(){
        // given
        int a = 5;
        int b = 52;
        int expected = -47;

        // when
        int actual = calculator.subtract(a,b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void givenTwoNumbers_WhenMultiply_ThenReturnDifference(){
        // given
        int a = 5;
        int b = 52;
        int expected = 260;

        // when
        int actual = calculator.multiply(a,b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void givenTwoNumbers_WhenDivine_ThenReturnDifference(){
        // given
        int a = 20;
        int b = 5;
        int expected = 4;

        // when
        int actual = calculator.divine(a,b);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void givenTwoNumbers_WhenDivineByZero_ThenThrowException(){
        // given
        int a = 20;
        int b = 0;

        // when
        // then
        assertThrows(ArithmeticException.class, () -> calculator.divine(a,b));
//        assertThrows(IllegalArgumentException.class, () -> calculator.divine(a,b));
    }
}
