package ec.yakindu.cqrs.infrastructure.bus;

import ec.yakindu.cqrs.domain.bus.Handler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleContainerTest {

    private SimpleContainer instance;

    @BeforeEach
    void setUp() {
        this.instance = new SimpleContainer();
    }

    @Test
    void whenFoundHandler_thenReturnHandler() {
        FakeCommandHandler commandHandler = new FakeCommandHandler();
        this.instance.provide(commandHandler);
        Handler handler = this.instance.make("FakeCommandHandler");

        assertEquals(commandHandler, handler);
    }

    @Test
    void whencontainerIsEmpty_throwsException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            this.instance.make("FakeCommandHandler");
        });

        String expectedMessage = "Handler [FakeCommandHandler] not found in container";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
