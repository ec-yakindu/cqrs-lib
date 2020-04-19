package ec.yakindu.cqrs.infrastructure.bus;

import ec.yakindu.cqrs.domain.bus.Inflector;
import ec.yakindu.cqrs.domain.bus.Message;

public class NameInflector<T extends Message> implements Inflector<T> {

    @Override
    public String inflect(T message) {
        String type = this.capitalize(message.type().toString());
        String name = message.getClass().getSimpleName();
        return name.replace(type, type + "Handler");
    }

    private String capitalize(String value) {
        String lower = value.toLowerCase();
        return lower.substring(0, 1).toUpperCase() + lower.substring(1);
    }
}
