package ec.yakindu.cqrs.domain.bus;

import java.util.UUID;

abstract public class Message {

    private UUID id;

    public Message(UUID id) {
        this.id = id;
    }

    public UUID id() {
        return this.id;
    }

    abstract public String type();
}
