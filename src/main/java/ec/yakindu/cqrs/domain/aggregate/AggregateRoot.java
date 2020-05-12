package ec.yakindu.cqrs.domain.aggregate;

import ec.yakindu.cqrs.domain.bus.event.Event;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot implements AggregatableRoot {

    protected List<Event> events = new ArrayList<>();
    private int version;

    final public List<Event> pullDomainEvents() {
        List<Event> events = this.events;
        this.events.clear();

        return events;
    }

    final public void record(Event domainEvent) {
        this.events.add(domainEvent);
    }

    public int version() {
        return this.version;
    }

    public void version(int version) {
        this.version = version;
    }

    public int increaseVersion() {
        version(version() + 1);
        return version();
    }
}
