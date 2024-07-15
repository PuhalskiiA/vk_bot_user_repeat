package org.example.vk_bot.models.objects_types;

public interface VKSideRequestMessageObject extends VKSideRequestObject {
    String getMessageText();
    Integer getFromId();
}
