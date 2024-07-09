package org.example.vk_bot.services.handlers;

import org.example.vk_bot.models.VKRequest;
import org.example.vk_bot.models.event_types.EventTypeMessage;
import org.example.vk_bot.utils.EventTypeHandler;
import org.example.vk_bot.utils.Token;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@EventTypeHandler(EventTypeMessage.class)
public final class MessageEventTypeHandler extends Handler {
    @Override
    public HttpStatus getResponse(VKRequest request) {
        try {
            HttpURLConnection connection = composeHttpURLConnection(request);
            connection.getResponseCode();

            return HttpStatus.OK;
        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }

    private static HttpURLConnection composeHttpURLConnection(VKRequest request) throws IOException {
        URL url = composeURL(request);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Bearer " + Token.getToken());

        return connection;
    }

    private static URL composeURL(VKRequest request) throws MalformedURLException {
        String urlString = "https://api.vk.com/method/messages.send?" +
                "user_id=" + request.getObject().getEvent().getFromId() +
                "&random_id=" + (int) (Math.random() * 2000000) +
                "&message=" + composeMessageFromInput(request) +
                "&v=" + request.getV();

        return new URL(urlString);
    }

    private static String composeMessageFromInput(VKRequest request) {
        String message = request.getObject().getEvent().getMessageText().replace(" ", "+");

        StringBuilder builder = new StringBuilder(message);
        builder.insert(0, "You+said+");

        return builder.toString();
    }
}
