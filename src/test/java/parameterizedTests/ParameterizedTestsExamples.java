package parameterizedTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTestsExamples {
    public static Stream<String> vegetablesProvider() {
        return Stream.of("Kartofelek", "Brokulik", "Marcheweczka");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testWithValueSourceAsInt(int value) {
        assertTrue(value > 0 && value < 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jabłko", "Banan", "Cytryna"})
    void testWithValueSourceAsString(String fruit) {
       assertNotNull(fruit);
    }
    @ParameterizedTest
    @NullSource
    void testWithValueSourceAsNull(String fruit) {
        assertNull(fruit);
//        assertTrue(fruit == null);
    }

    @ParameterizedTest
    @EmptySource
    void testWithValueSourceAsEmptySource(String fruit) {
        assertTrue(fruit.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testWithValueSourceAsEmptySourceAndAsNull(String fruit) {
        assertTrue(fruit == null || fruit.isEmpty());
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void testWithEnumSource(Month month){
        assertNotNull(month);
    }

    @ParameterizedTest
    @CsvSource({"Jabłko, 2, false","Banan, 5, true","Wiśnia, 19, false"})
    void testWithCsvSource(String fruit, int number, boolean isSezon){
        assertNotNull(fruit);
        assertTrue(number > 1);
//        assertTrue(isSezon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", useHeadersInDisplayName = true)
    void testWithCSVFileSource(String vegetables, int number){
        assertNotNull(vegetables);
        assertTrue(number > 0);
    }


    @ParameterizedTest
    @MethodSource("vegetablesProvider")
    void testWithMethodSource(String vegetables){
        assertNotNull(vegetables);
    }

    @ParameterizedTest
    @ArgumentsSource(CustomerArgumentsProvider.class)
    void testWithCustomArgumentsSource(String text, int number){
        assertNotNull(text);
        assertTrue(number > 0);
    }

}
