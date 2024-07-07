package org.example.vk_bot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.vk_bot.models.objects_types.VKSideRequestObject;
import org.example.vk_bot.models.objects_types.VKSideRequestObjectMessageEvent;
import org.example.vk_bot.models.objects_types.VKSideRequestObjectMessageReadEvent;
import org.example.vk_bot.models.objects_types.VKSideRequestObjectMessageReplyEvent;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VKRequest {
    String type;

    @JsonProperty("group_id")
    String groupId;

    @JsonProperty("event_id")
    String eventId;

    String v;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "type"
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = VKSideRequestObjectMessageEvent.class, name = "message_new"),
            @JsonSubTypes.Type(value = VKSideRequestObjectMessageReplyEvent.class, name = "message_reply"),
            @JsonSubTypes.Type(value = VKSideRequestObjectMessageReadEvent.class, name = "message_read")
    })
    VKSideRequestObject object;
}
