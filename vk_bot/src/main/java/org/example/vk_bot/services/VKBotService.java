package org.example.vk_bot.services;

import org.example.vk_bot.models.VKRequest;
import org.springframework.http.HttpStatus;

public interface VKBotService {
    HttpStatus getResponse(VKRequest request);
}
