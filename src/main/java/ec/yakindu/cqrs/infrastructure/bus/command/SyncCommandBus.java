package ec.yakindu.cqrs.infrastructure.bus.command;

import ec.yakindu.cqrs.domain.bus.Container;
import ec.yakindu.cqrs.domain.bus.Handler;
import ec.yakindu.cqrs.domain.bus.Inflector;
import ec.yakindu.cqrs.domain.bus.command.Command;
import ec.yakindu.cqrs.domain.bus.command.CommandBus;

import java.util.Optional;

public class SyncCommandBus implements CommandBus {

    private Container<Handler> container;
    private Inflector inflector;

    public SyncCommandBus(Container<Handler> container, Inflector inflector) {
        this.container = container;
        this.inflector = inflector;
    }

    @Override
    public Optional<?> dispatch(Command command) {
        return Optional.of(this.handler(command).handle(command));
    }

    private Handler handler(Command command) {
        String name = this.inflector.inflect(command);
        return this.container.make(name);
    }
}
