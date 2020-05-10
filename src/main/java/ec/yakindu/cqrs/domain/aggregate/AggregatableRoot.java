package ec.yakindu.cqrs.domain.aggregate;

import ec.yakindu.cqrs.domain.bus.event.DomainEvent;

import java.util.List;

public interface AggregatableRoot {

    int version();
    List<DomainEvent> pullDomainEvents();
    void record(DomainEvent domainEvent);
    void apply(DomainEvent domainEvent);
}
