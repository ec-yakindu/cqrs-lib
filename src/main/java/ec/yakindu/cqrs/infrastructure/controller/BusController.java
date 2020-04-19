package ec.yakindu.cqrs.infrastructure.controller;

import ec.yakindu.cqrs.domain.bus.command.Command;
import ec.yakindu.cqrs.domain.bus.command.CommandBus;
import ec.yakindu.cqrs.domain.bus.query.Query;
import ec.yakindu.cqrs.domain.bus.query.QueryBus;

import java.util.Optional;

abstract public class BusController {

    private QueryBus queryBus;
    private CommandBus commandBus;

    public BusController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    protected Optional<?> dispatch(Command command) {
        return this.commandBus.dispatch(command);
    }

    protected Object ask(Query query) {
        return this.queryBus.ask(query);
    }
}
