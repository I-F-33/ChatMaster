package com.devflores.chatmaster.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Channel {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "channel")
	private List<Message> messages;
	
	@Column(name = "channel_name")
	private String channelName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="channel_id")
	private Long channelId;


	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	@Override
	public String toString() {
		return "Channel [messages=" + messages + ", channelName=" + channelName + ", channelId=" + channelId + "]";
	}
	
	
}
