package org.example.vk_bot.services.handlers;

import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.models.event_types.EventTypeMessageReply;
import org.example.vk_bot.utils.EventTypeHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@EventTypeHandler(EventTypeMessageReply.class)
public final class MessageEventTypeReplyHandler extends Handler {
    @Override
    public HttpStatus getResponse(VKRequest request) {
        return HttpStatus.OK;
    }
}
