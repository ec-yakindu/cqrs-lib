package ec.yakindu.cqrs.domain.command;

import ec.yakindu.cqrs.domain.bus.Message;

import java.util.UUID;

abstract public class Command extends Message {

    public Command(UUID id) {
        super(id);
    }

    public String type() {
        return "command";
    }

    abstract public static class Builder<T> {
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
