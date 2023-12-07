package zadania;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    private final EmailValidator emailValidator = new EmailValidator();

    @Test
    void isValid_withSingleEmail() {
        // GIVEN
        String email = "test@example.com";

        // WHEN
        boolean result = emailValidator.isValid(email);

        // THEN
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "user@domain.com", "john.doe@mail.co"})
    void isValid_withValueSource(String email) {
        // WHEN
        boolean result = emailValidator.isValid(email);

        // THEN
        assertTrue(result);
    }

    static Stream<Arguments> validAndInvalidEmails() {
        return Stream.of(
                Arguments.of("test@example.com", true),
                Arguments.of("user@domain.com", true),
                Arguments.of("john.doe@mail.co", true),
                Arguments.of("invalid_email", false),
                Arguments.of("invalid.com", false)
        );
    }

    @ParameterizedTest
    @MethodSource("validAndInvalidEmails")
    void isValid_withMethodSource(String email, boolean expected) {
        // WHEN
        boolean result = emailValidator.isValid(email);

        // THEN
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "test@example.com, true",
            "user@domain.com, true",
            "john.doe@mail.co, true",
            "invalid_email, false",
            "invalid.com, false"
    })
    void isValid_withCsvSource(String email, boolean expected) {
        // WHEN
        boolean result = emailValidator.isValid(email);

        // THEN
        assertEquals(expected, result);
    }
}

