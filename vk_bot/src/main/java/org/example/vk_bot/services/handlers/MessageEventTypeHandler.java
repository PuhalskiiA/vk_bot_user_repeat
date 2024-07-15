package org.example.vk_bot.services.handlers;

import lombok.RequiredArgsConstructor;
import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.models.objects_types.VKSideRequestMessageObject;
import org.example.vk_bot.models.objects_types.VKSideRequestObjectMessageEvent;
import org.example.vk_bot.utils.EventTypeHandler;
import org.example.vk_bot.utils.Token;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@EventTypeHandler(VKSideRequestObjectMessageEvent.class)
public final class MessageEventTypeHandler extends Handler {
    private final RestTemplate restTemplate;

    @Override
    public HttpStatusCode getResponse(VKRequest request) {
        HttpEntity<String> entity = new HttpEntity<>(composeHeaders());

        ResponseEntity<String> response = restTemplate
                .exchange(composeURI(request), HttpMethod.GET, entity, String.class);

        return response.getStatusCode();
    }

    private static HttpHeaders composeHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + Token.getToken());

        return headers;
    }

    private static URI composeURI(VKRequest request) {
        VKSideRequestMessageObject object = (VKSideRequestMessageObject) request.getObject();

        UriComponents builder = UriComponentsBuilder.newInstance()
                .scheme("https").host("api.vk.com").path("/method/messages.send")
                .queryParam("user_id", object.getFromId())
                .queryParam("random_id", ThreadLocalRandom.current().nextInt())
                .queryParam("message", composeMessageFromInputObject(object))
                .queryParam("v", request.getV())
                .build();

        return builder.toUri();
    }

    private static String composeMessageFromInputObject(VKSideRequestMessageObject object) {
        String message = object.getMessageText().replace(" ", "+");

        StringBuilder builder = new StringBuilder(message);
        builder.insert(0, "You+said+");

        return builder.toString();
    }
}
