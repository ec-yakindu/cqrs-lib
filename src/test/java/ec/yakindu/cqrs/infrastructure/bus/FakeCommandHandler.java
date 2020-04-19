package ec.yakindu.cqrs.infrastructure.bus;

import ec.yakindu.cqrs.domain.bus.Handler;
import ec.yakindu.cqrs.domain.bus.command.Command;

public class FakeCommandHandler implements Handler<Command, String> {
    public String response = "success";

    @Override
    public String handle(Command message) {
        return this.response;
    }
}
