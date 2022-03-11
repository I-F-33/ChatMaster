package com.devflores.chatmaster.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
	
    @JsonProperty("senderName")
    private String senderName;
    @JsonProperty("messageContent")
    private String messageContent;
    @JsonProperty("channelId")
    private Long channelId;
    @JsonProperty("userId")
    private Long userId;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
