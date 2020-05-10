package ec.yakindu.cqrs.infrastructure.bus.query;

import ec.yakindu.cqrs.domain.bus.Container;
import ec.yakindu.cqrs.domain.bus.Handler;
import ec.yakindu.cqrs.domain.bus.Inflector;
import ec.yakindu.cqrs.domain.bus.query.Query;
import ec.yakindu.cqrs.domain.bus.query.QueryBus;

import java.util.Optional;

public class SyncQueryBus implements QueryBus {

    private Container<Handler> container;
    private Inflector inflector;

    public SyncQueryBus(Container<Handler> container, Inflector inflector) {
        this.container = container;
        this.inflector = inflector;
    }

    @Override
    public Optional<?> ask(Query query) {
        return Optional.of(this.handler(query).handle(query));
    }

    private Handler handler(Query query) {
        String name = this.inflector.inflect(query);
        return this.container.make(name);
    }
}
