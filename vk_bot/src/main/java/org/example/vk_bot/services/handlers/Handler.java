package org.example.vk_bot.services.handlers;

import org.example.vk_bot.models.VKRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Component
public abstract class Handler {
    public abstract HttpStatusCode getResponse(VKRequest request);
}
