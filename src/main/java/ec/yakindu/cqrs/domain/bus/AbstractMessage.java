package ec.yakindu.cqrs.domain.bus;

import java.util.UUID;

abstract public class AbstractMessage implements Message {

    private UUID id;

    public AbstractMessage(UUID id) {
        this.id = id;
    }

    public UUID id() {
        return this.id;
    }

    abstract public MessageType type();
}
