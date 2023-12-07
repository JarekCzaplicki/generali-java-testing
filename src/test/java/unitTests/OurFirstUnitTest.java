package unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OurFirstUnitTest { // klasa testowa

    @Test
        // adnotacja oznaczająca, że metoda jest testem
    void should_Multiply_Two_Numbers() { // sygnatura metody testowej w przeciwienstwie do JUnit4 nie musi być publiczna
        // given // warunki początkowe
        final double firstNumber = 2;
        final double secondNumber = 3;
        final double expected = 6;

        // when // wykonanie testu
        final double actual = firstNumber * secondNumber;

        //then // sprawdzenie wyniku testu
        assertEquals(expected, actual);
    }

    //    BDD
    @Test
    void givenTwoNumbers_WhenMultiply_ThenActualEqualExpected() {
        // given
        int firstNumber = 3;
        int secondNumber = 10;
        int expected = 30;

        // when
        int actual = firstNumber * secondNumber;

        //then
        assertEquals(expected, actual);
    }

    @Test
    void givenWhenBooleanValuIsTrue_ThenAsertTrue() {
        // given
        // when
        boolean actual = (2 + 2) == 4;

        // then
        assertTrue(actual);
    }

    @DisplayName("Przykład użycia assertFalse")
    @Test
    void givenWhenBooleanValuIsFalse_ThenAsertFalse() {
        // given
        // when
        boolean actual = (2 + 2) == 5;

        // then
        assertFalse(actual);
    }

    @DisplayName("Przykład użycia assertNull")
    @Test
    void givenWhenNullAsObject_ThenAsertNull() {
        // given
        // when
        Person actual = null;

        // then
        assertNull(actual);
    }

    @DisplayName("Przykład użycia assertNotNull")
    @Test
    void givenWhenObject_ThenAsertNotNull() {
        // given
        // when
        Person actual = new Person();

        // then
        assertNotNull(actual);
    }

    @Disabled
    @Test
    void givenTwoArrays_WhenArraysAreEqual_ThenTestPass() {
        // given
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 4};

        // when
        // then
        assertArrayEquals(expected, actual, "Elements in arrays are not equals");
    }

    @Test
    void givenTwoLists_WhenListsAreEqual_ThenTestPass() {
        // given
        List<Integer> expected = Arrays.asList(1,2,3);
        List<Integer> actual = Arrays.asList(1,2,3);

        // when
        // then
        assertIterableEquals(expected, actual, "Elements in lists are not equals");
    }
    @Test
    void bothArraysShouldBeEqual() {
        List<Integer> ints = Arrays.asList(1, 3, 2);

        assertAll(
                () -> assertEquals(3, ints.size()),
                () -> assertEquals(6, ints.get(2))
        );
    }


}
