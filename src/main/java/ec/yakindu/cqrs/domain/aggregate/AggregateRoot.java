package ec.yakindu.cqrs.domain.aggregate;

import ec.yakindu.cqrs.domain.bus.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot {

    private List<DomainEvent> domainEvents = new ArrayList<>();

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = this.domainEvents;
        this.domainEvents.clear();

        return events;
    }

    final protected void record(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }
}
