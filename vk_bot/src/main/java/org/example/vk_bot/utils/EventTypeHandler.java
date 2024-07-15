package org.example.vk_bot.utils;

import org.example.vk_bot.models.objects_types.VKSideRequestObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value= RetentionPolicy.RUNTIME)
public @interface EventTypeHandler {
    Class<? extends VKSideRequestObject> value();
}
