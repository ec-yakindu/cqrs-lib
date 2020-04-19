package ec.yakindu.cqrs.domain.bus;

public interface Inflector<T> {
    String inflect(T message);
}
