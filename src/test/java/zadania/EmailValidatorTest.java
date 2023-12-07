package zadania;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Zadanie 2:
//Napisz metodę 'isValid' która przyjmuje obiekt typu String.
//Metoda m być częścią klasy 'EmailValidator'
//zdefiniuj w klasie:
//- regex dla sprawdzania email
//Napisz testy gdzie jako źródło danych będzie:
//- pojedynczy mail
//- @ValueSource
//- @MethodSource (jeden test z listą prawidłowych maili, drugi z listą nieprawidłowych maili)
//- @CsvSource
public class EmailValidatorTest {
    private final EmailValidator emailValidator = new EmailValidator();

    public static Stream<Arguments> validAndInvalidEmails() {
        return Stream.of(
                Arguments.of("test@example.com", true),
                Arguments.of("user@domain.com", true),
                Arguments.of("jarek.cz@gmail.com", true),
                Arguments.of("invalid_email", false),
                Arguments.of("invalid.com", false)
        );
    }

    @Test
    void givenSingleEmail_WhenValidated_ThenTrue(){
        // given
        String email = "test@test.pl";

        // when
        boolean valid = emailValidator.isValid(email);

        // then
        assertTrue(valid);
    }
    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "user@domain.com", "jarek@gmail.com"})
    void givenArrayOfEmails_whenValidated_ThenTrue(String email){
        // when
        boolean valid = emailValidator.isValid(email);

        // then
        assertTrue(valid);
    }

    @ParameterizedTest
    @MethodSource("validAndInvalidEmails")
    void givenStreamOfArguments_WhenValidated_ThenEquals(String email, boolean expected){
        // when
        boolean actual = emailValidator.isValid(email);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "test@example.com, true",
            "user@domain.com, true",
            "jarek.cz@gmail.com, true",
            "invalid_email, false",
            "invalid.com, false"
    })
    void givenCsvSource_WhenValidated_ThenEquals (String email, boolean expected){
        // when
        boolean actual = emailValidator.isValid(email);

        // then
        assertEquals(expected, actual);
    }
}
