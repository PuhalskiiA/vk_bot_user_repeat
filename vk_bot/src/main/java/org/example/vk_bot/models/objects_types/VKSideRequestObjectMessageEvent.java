package org.example.vk_bot.models.objects_types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VKSideRequestObjectMessageEvent implements VKSideRequestMessageObject {
    @JsonProperty("message")
    EventTypeMessage eventTypeMessage;

    @Override
    public String getMessageText() {
        return eventTypeMessage.getText();
    }

    @Override
    public Integer getFromId() {
        return eventTypeMessage.getFromId();
    }
}
