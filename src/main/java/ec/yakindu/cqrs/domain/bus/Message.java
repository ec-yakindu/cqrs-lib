package ec.yakindu.cqrs.domain.bus;

import java.util.UUID;

public interface Message {

    UUID id();

    MessageType type();

    String fullyQualifiedName();

}
