package org.example.vk_bot.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.services.VKBotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class WebhookController {
    VKBotService VKBotService;

    @PostMapping(value = "/webhook")
    public ResponseEntity<String> receiveWebhook(@RequestBody VKRequest request) {
        if (VKBotService.getResponse(request).is2xxSuccessful()) {
            return new ResponseEntity<>("ok", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
