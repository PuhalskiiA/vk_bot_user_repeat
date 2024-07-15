package org.example.vk_bot.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.services.handlers.Handler;
import org.example.vk_bot.utils.EventTypeHandlerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class VKBotServiceImpl implements VKBotService {
    final EventTypeHandlerRepository handlerRepository;

    @Override
    public HttpStatusCode getResponse(VKRequest request) {
        Handler handler = handlerRepository.getHandler(request.getObject().getClass());

        if (handler == null) return HttpStatus.BAD_REQUEST;

        return handler.getResponse(request);
    }
}
