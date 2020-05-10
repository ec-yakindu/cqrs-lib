package ec.yakindu.cqrs.domain.bus.event;

import ec.yakindu.cqrs.domain.bus.Message;
import ec.yakindu.cqrs.domain.bus.MessageType;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public abstract class DomainEvent extends Message {

    private String eventId;
    private String aggregateId;
    private Map<String, Object> data;
    private String occurredOn;

    public DomainEvent(String aggregateId, Map<String, Object> data) {
        this(aggregateId, data, UUID.randomUUID().toString(), Instant.now().toString());
    }

    public DomainEvent(String aggregateId, Map<String, Object> data, String eventId, String occurredOn) {
        super(UUID.fromString(eventId));

        this.eventId = eventId;
        this.aggregateId = aggregateId;
        this.data = data;
        this.occurredOn = occurredOn;
    }

    public static String eventName() {
        return null;
    }

    @Override
    public MessageType type() {
        return MessageType.EVENT;
    }

    public String eventId() {
        return this.eventId;
    }

    public String aggregateId() {
        return this.aggregateId;
    }

    public Map<String, Object> data() {
        return this.data;
    }

    public String occurredOn() {
        return this.occurredOn;
    }
}
