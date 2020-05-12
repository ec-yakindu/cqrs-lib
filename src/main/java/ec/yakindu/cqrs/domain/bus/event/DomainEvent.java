package ec.yakindu.cqrs.domain.bus.event;

import ec.yakindu.cqrs.domain.bus.AbstractMessage;
import ec.yakindu.cqrs.domain.bus.MessageType;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class DomainEvent extends AbstractMessage implements Event {

    private String eventId;
    private String aggregateId;
    private Map<String, Object> data;
    private Map<String, Object> meta;
    private String occurredOn;

    public DomainEvent(String aggregateId, Map<String, Object> data) {
        this(aggregateId, data, UUID.randomUUID().toString(), Instant.now().toString(), new HashMap<>());
    }

    public DomainEvent(String aggregateId, Map<String, Object> data, Map<String, Object> meta) {
        this(aggregateId, data, UUID.randomUUID().toString(), Instant.now().toString(), meta);
    }

    public DomainEvent(String aggregateId, Map<String, Object> data, String eventId, String occurredOn, Map<String, Object> meta) {
        super(UUID.fromString(eventId));

        this.eventId = eventId;
        this.aggregateId = aggregateId;
        this.data = data;
        this.meta = meta;
        this.occurredOn = occurredOn;
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

    public Map<String, Object> meta() {
        return this.meta;
    }

    public String occurredOn() {
        return this.occurredOn;
    }
}
