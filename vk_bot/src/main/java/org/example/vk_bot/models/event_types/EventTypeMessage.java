package org.example.vk_bot.models.event_types;

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
public class EventTypeMessage extends EventType {
    Integer id;

    @JsonProperty("peer_id")
    Integer peerId;

    @JsonProperty("from_id")
    Integer fromId;

    String text;

    @Override
    public String getMessageText() {
        return text;
    }
}
