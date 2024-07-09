package org.example.vk_bot.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.event_types.EventType;
import org.example.vk_bot.services.handlers.Handler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class EventTypeHandlerRepository {
    Map<Class<? extends EventType>, Handler> handlers = new HashMap<>();

    public EventTypeHandlerRepository(List<Handler> handlers) {
        handlers.forEach(eventTypeHandler -> {
            if (eventTypeHandler.getClass().isAnnotationPresent(EventTypeHandler.class)) {
                Class<? extends EventType> eventTypeClass = eventTypeHandler.getClass().getAnnotation(EventTypeHandler.class).value();

                this.handlers.put(eventTypeClass, eventTypeHandler);
            }
        });
    }

    public Handler getHandler(Class<? extends EventType> sideRequestObjectClassName) {
        return handlers.get(sideRequestObjectClassName);
    }
}
