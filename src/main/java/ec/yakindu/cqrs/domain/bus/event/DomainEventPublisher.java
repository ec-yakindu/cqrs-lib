package ec.yakindu.cqrs.domain.bus.event;

public interface DomainEventPublisher {

    void record(DomainEvent... domainEvents);

    void publishRecorded();

    void publish(DomainEvent... domainEvents);
}
