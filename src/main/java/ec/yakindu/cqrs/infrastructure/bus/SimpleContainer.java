package ec.yakindu.cqrs.infrastructure.bus;

import ec.yakindu.cqrs.domain.bus.Container;
import ec.yakindu.cqrs.domain.bus.Handler;

import java.util.HashMap;
import java.util.Map;

public class SimpleContainer implements Container<Handler> {

    private Map<String, Handler> list;

    public SimpleContainer() {
        this.list = new HashMap<>();
    }

    @Override
    public Handler make(String typeName) {
        Handler handler = list.get(typeName);
        if (handler == null) {
            throw new RuntimeException("Handler [" + typeName + "] not found in container");
        }
        return handler;
    }

    public void provide(Handler handler) {
        String key = handler.getClass().getSimpleName();
        this.list.put(key, handler);
    }
}
