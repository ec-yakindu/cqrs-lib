package ec.yakindu.cqrs.domain.aggregate;

import ec.yakindu.cqrs.domain.bus.event.Event;

import java.util.List;

public interface AggregatableRoot {

    int version();

    List<Event> pullDomainEvents();

    void record(Event event);

    void apply(Event... event);
}
