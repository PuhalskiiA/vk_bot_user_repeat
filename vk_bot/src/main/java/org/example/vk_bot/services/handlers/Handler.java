package org.example.vk_bot.services.handlers;

import org.example.vk_bot.models.VKRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public abstract class Handler {
    public abstract HttpStatus getResponse(VKRequest request);
}
