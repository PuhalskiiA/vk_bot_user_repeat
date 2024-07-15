package org.example.vk_bot.services;

import org.example.vk_bot.models.VKRequest;
import org.springframework.http.HttpStatusCode;

public interface VKBotService {
    HttpStatusCode getResponse(VKRequest request);
}
