package org.example.vk_bot.models.objects_types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.event_types.EventType;
import org.example.vk_bot.models.event_types.EventTypeMessage;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VKSideRequestObjectMessageEvent extends VKSideRequestObject {
    @JsonProperty("message")
    EventTypeMessage eventTypeMessage;

    @Override
    public EventType getEvent() {
        return eventTypeMessage;
    }
}
