package org.example.vk_bot.models.objects_types;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.event_types.EventType;
import org.example.vk_bot.models.event_types.EventTypeMessageReply;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class VKSideRequestObjectMessageReplyEvent extends VKSideRequestObject {
    @Override
    public EventType getEvent() {
        return new EventTypeMessageReply();
    }
}
