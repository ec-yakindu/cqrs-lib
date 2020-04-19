package ec.yakindu.cqrs.domain.bus;

public interface Container<T> {
    T make(String typeName);
}
