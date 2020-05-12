package ec.yakindu.cqrs.domain.bus.event;

import java.util.Map;

public interface Event {

    String eventId();

    String eventName();

//    String fullyQualifiedName();

    String aggregateId();

    Map<String, Object> data();

    Map<String, Object> meta();

    String occurredOn();

}
