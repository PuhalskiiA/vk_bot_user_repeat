package org.example.vk_bot.services.handlers;

import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.models.objects_types.VKSideRequestObjectMessageReadEvent;
import org.example.vk_bot.utils.EventTypeHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@EventTypeHandler(VKSideRequestObjectMessageReadEvent.class)
public final class MessageEventTypeReadHandler extends Handler {
    @Override
    public HttpStatusCode getResponse(VKRequest request) {
        return HttpStatus.OK;
    }
}
