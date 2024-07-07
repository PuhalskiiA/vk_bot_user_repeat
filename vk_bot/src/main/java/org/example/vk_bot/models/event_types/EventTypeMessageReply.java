package org.example.vk_bot.models.event_types;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventTypeMessageReply extends EventType {
    @Override
    public String getMessageText() {
        return null;
    }

    @Override
    public Integer getFromId() {
        return null;
    }
}
