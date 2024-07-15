package org.example.vk_bot.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.objects_types.VKSideRequestObject;
import org.example.vk_bot.services.handlers.Handler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class EventTypeHandlerRepository {
    Map<Class<? extends VKSideRequestObject>, Handler> handlers = new HashMap<>();

    public EventTypeHandlerRepository(List<Handler> handlers) {
        handlers.forEach(eventTypeHandler -> {
            if (eventTypeHandler.getClass().isAnnotationPresent(EventTypeHandler.class)) {
                Class<? extends VKSideRequestObject> objectTypeClass = eventTypeHandler.getClass()
                        .getAnnotation(EventTypeHandler.class).value();

                this.handlers.put(objectTypeClass, eventTypeHandler);
            }
        });
    }

    public Handler getHandler(Class<? extends VKSideRequestObject> sideRequestObjectClass) {
        return handlers.get(sideRequestObjectClass);
    }
}
