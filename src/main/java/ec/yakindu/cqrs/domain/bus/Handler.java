package ec.yakindu.cqrs.domain.bus;

public interface Handler<T, R> {
    R handle(T message);
}
