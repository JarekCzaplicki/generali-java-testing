package mockito;

import org.junit.jupiter.api.extension.*;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.quality.Strictness;

public class MockitoSessionParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(MockitoSession.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return Mockito.mockitoSession()
                .initMocks(parameterContext.getDeclaringExecutable().getAnnotatedReceiverType().getAnnotatedOwnerType())
                .strictness(Strictness.STRICT_STUBS)
                .startMocking();
    }
}
