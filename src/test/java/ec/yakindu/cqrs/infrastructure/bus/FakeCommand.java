package ec.yakindu.cqrs.infrastructure.bus;

import ec.yakindu.cqrs.domain.bus.command.Command;

import java.util.UUID;

public class FakeCommand extends Command {

    public FakeCommand() {
        super(UUID.randomUUID());
    }
}
