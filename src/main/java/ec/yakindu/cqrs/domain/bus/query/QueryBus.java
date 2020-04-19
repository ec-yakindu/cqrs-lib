package ec.yakindu.cqrs.domain.bus.query;

import java.util.Optional;

public interface QueryBus {

    Optional<?> ask(Query query);
}
