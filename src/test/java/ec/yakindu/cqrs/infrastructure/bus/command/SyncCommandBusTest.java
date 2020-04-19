package ec.yakindu.cqrs.infrastructure.bus.command;

import ec.yakindu.cqrs.domain.bus.Handler;
import ec.yakindu.cqrs.domain.bus.Inflector;
import ec.yakindu.cqrs.domain.bus.command.Command;
import ec.yakindu.cqrs.infrastructure.bus.FakeCommand;
import ec.yakindu.cqrs.infrastructure.bus.FakeCommandHandler;
import ec.yakindu.cqrs.infrastructure.bus.NameInflector;
import ec.yakindu.cqrs.infrastructure.bus.SimpleContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SyncCommandBusTest {

    private SyncCommandBus instance;
    private SimpleContainer container;

    @BeforeEach
    void setUp() {
        this.container = new SimpleContainer();
        Inflector<Command> inflector = new NameInflector();
        this.instance = new SyncCommandBus(container, inflector);
    }

    @Test
    void whenContainerIsEmpty_thenThrowsException() {
        Command command = new FakeCommand();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            this.instance.dispatch(command);
        });

        String expectedMessage = "Handler [FakeCommandHandler] not found in container";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void returnSuccessResponse() {
        Command command = new FakeCommand();
        Handler fakeCommandHander = new FakeCommandHandler();
        this.container.provide(fakeCommandHander);

        Optional<?> result = this.instance.dispatch(command);
        String got = (String) result.get();
        assertEquals(result.isPresent(), true);
        assertEquals(got, "success");

    }
}
