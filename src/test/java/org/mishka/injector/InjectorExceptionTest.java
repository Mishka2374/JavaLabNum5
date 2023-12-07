package org.mishka.injector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InjectorExceptionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInjectorException() {
        thrown.expect(InjectorException.class);
        thrown.expectMessage("Expected message");

        // вызов метода, который должен выбросить исключение
        throw new InjectorException("Expected message");
    }
}