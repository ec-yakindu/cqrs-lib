package ec.yakindu.cqrs.domain.bus.command;

import java.util.Optional;

public interface CommandBus {
    Optional<?> dispatch(Command command);
}
