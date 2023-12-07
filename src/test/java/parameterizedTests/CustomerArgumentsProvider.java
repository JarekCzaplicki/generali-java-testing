package parameterizedTests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomerArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("Jarek", 44),
                Arguments.of("Arek", 4),
                Arguments.of("Marek", 24),
                Arguments.of("Karol", 54)
        );
    }
}
