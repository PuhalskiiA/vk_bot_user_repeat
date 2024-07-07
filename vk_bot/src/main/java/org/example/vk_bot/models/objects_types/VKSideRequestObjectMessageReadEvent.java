package org.example.vk_bot.models.objects_types;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.event_types.EventType;
import org.example.vk_bot.models.event_types.EventTypeMessageRead;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class VKSideRequestObjectMessageReadEvent extends VKSideRequestObject {
    @Override
    public EventType getEvent() {
        return new EventTypeMessageRead();
    }
}
