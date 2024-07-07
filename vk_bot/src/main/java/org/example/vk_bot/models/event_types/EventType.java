package org.example.vk_bot.models.event_types;

public abstract class EventType {
    public abstract String getMessageText();
    public abstract Integer getFromId();
}
