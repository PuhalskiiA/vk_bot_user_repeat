package org.example.vk_bot.utils;

import org.example.vk_bot.models.event_types.EventType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value= RetentionPolicy.RUNTIME)
public @interface EventTypeHandler {
    Class<? extends EventType> value();
}
