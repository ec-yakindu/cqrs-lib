package ec.yakindu.cqrs.domain.bus.query;

import ec.yakindu.cqrs.domain.bus.Message;
import ec.yakindu.cqrs.domain.bus.MessageType;

import java.util.UUID;

abstract public class Query extends Message {

    public Query(UUID id) {
        super(id);
    }

    public MessageType type() {
        return MessageType.QUERY;
    }

    public static class Builder<T> {
        protected UUID queryId;

        public T queryId(UUID value) {
            this.queryId = value;
            return (T) this;
        }

        protected void checkQueryId() {
            if (this.queryId == null) {
                this.queryId = UUID.randomUUID();
            }
        }

        public UUID queryId() {
            return this.queryId;
        }
    }
}
