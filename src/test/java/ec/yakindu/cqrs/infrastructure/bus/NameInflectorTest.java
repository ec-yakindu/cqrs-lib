package ec.yakindu.cqrs.infrastructure.bus;

import ec.yakindu.cqrs.domain.bus.command.Command;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameInflectorTest {

    private static NameInflector instance;

    @BeforeAll
    static void setup() {
        instance = new NameInflector();
    }

    @Test
    void inflectCommand() {
        Command command = new FakeCommand();
        assertEquals("FakeCommandHandler", this.instance.inflect(command));
    }
}
