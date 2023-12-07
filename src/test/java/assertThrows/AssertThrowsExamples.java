package assertThrows;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrowsExamples {

    @Test
    void shouldThrowNullPointerException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertThrows(NullPointerException.class, () -> {
            assertThrowsExampleClass.getStringLength(null);
        });
    }

    @Test
    void shouldThrowArithmeticException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertThrows(ArithmeticException.class, () -> {
            assertThrowsExampleClass.divide(10, 0);
        });
    }

    @Test
    void shouldThrowArrayIndexOutOfBoundsException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        int[] numbers = {1,2,3};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            assertThrowsExampleClass.getElementAtIndex(numbers, 3);
        });
    }

    @Test
    void shouldThrowUserDefinedException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertThrows(UserDefinedException.class, assertThrowsExampleClass::throwUserDefinedException);
    }

    @Test
    void shouldThrowIllegalArgumentException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertThrows(IllegalArgumentException.class,
                assertThrowsExampleClass::throwIllegalArgumentException);
    }

    @Test
    void shouldThrowFileNotFoundException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertThrows(FileNotFoundException.class,
                assertThrowsExampleClass::readFromFile);
    }

    @Test
    void shouldDoesNotThrowException() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertDoesNotThrow(() ->{
            assertThrowsExampleClass.getStringLength("SDA");
        });
    }

    @Test
    void shouldThrowFileNotFoundException2() {
        AssertThrowsExampleClass assertThrowsExampleClass = new AssertThrowsExampleClass();
        assertThrows(Exception.class,
                () -> assertThrowsExampleClass.throwMultipleExceptions(false));
    }

}
