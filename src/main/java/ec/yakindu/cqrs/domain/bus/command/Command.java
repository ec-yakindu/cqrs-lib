package ec.yakindu.cqrs.domain.bus.command;

import ec.yakindu.cqrs.domain.bus.AbstractMessage;
import ec.yakindu.cqrs.domain.bus.MessageType;

import java.util.UUID;

abstract public class Command extends AbstractMessage {

    public Command(UUID id) {
        super(id);
    }

    public MessageType type() {
        return MessageType.COMMAND;
    }

    public static class Builder<T> {
        protected UUID commandId;

        public T commandId(UUID value) {
            this.commandId = value;
            return (T) this;
        }

        protected void checkCommandId() {
            if (this.commandId == null) {
                this.commandId = UUID.randomUUID();
            }
        }

        public UUID commandId() {
            return this.commandId;
        }
    }
}
