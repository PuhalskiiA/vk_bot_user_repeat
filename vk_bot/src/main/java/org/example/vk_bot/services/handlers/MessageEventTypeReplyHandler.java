package org.example.vk_bot.services.handlers;

import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.models.objects_types.VKSideRequestObjectMessageReplyEvent;
import org.example.vk_bot.utils.EventTypeHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@EventTypeHandler(VKSideRequestObjectMessageReplyEvent.class)
public final class MessageEventTypeReplyHandler extends Handler {
    @Override
    public HttpStatusCode getResponse(VKRequest request) {
        return HttpStatus.OK;
    }
}
