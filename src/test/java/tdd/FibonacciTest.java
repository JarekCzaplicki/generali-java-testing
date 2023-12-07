package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FibonacciTest {
    @Test
    void givenWhenCreatingClassThenShouldPas(){
        // given
        // when
        int value = Fibonacci.getValue(0);

        //then
        assertNotNull(value);
    }
    @Test
    void shouldReturnZeroForZeroElement() {
        assertEquals(0, Fibonacci.getValue(0));
    }
    @Test
    void shouldReturnOneForFirstElement() {
        assertEquals(1, Fibonacci.getValue(1));
    }

    @Test
    void shouldReturnValue() {
        assertEquals(8, Fibonacci.getValueRec(6));
        assertEquals(144, Fibonacci.getValueRec(12));
        assertEquals(987, Fibonacci.getValueRec(16));
    }
}
