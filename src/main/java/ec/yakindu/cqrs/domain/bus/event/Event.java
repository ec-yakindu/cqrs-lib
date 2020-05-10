package ec.yakindu.cqrs.domain.bus.event;

import ec.yakindu.cqrs.domain.bus.MessageType;

import java.util.Map;

public interface Event {

    String eventId();

    String eventName();

    String fullyQualifiedName();

    MessageType type();

    String aggregateId();

    Map<String, Object> data();

    Map<String, Object> meta();

    String occurredOn();

}
