package com.devflores.chatmaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devflores.chatmaster.domain.Message;
import com.devflores.chatmaster.dto.MessageDTO;
import com.devflores.chatmaster.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	public Message createMessage(MessageDTO messageDto) {
		Message message = new Message();
		message.setChannel(channelService.findById(messageDto.getChannelId()));
		message.setUser(userService.findById(messageDto.getUserId()));
		message.setMessageText(messageDto.getMessageContent());
		return messageRepo.save(message);
	}
	
	public List<Message> findAll () {
		return messageRepo.findAll();
	}
	
	public List<MessageDTO> findAllByChannelId(Long channelId) {
		List <Message> messages = messageRepo.findAllByChannelId(channelId);
		List<MessageDTO> displayedMessages = new ArrayList<>();
		for (Message message: messages) {
			MessageDTO fetchedMessage = new MessageDTO();
			fetchedMessage.setChannelId(message.getChannel().getChannelId());
			fetchedMessage.setUserId(message.getUser().getUserId());
			fetchedMessage.setMessageContent(message.getMessageText());
			fetchedMessage.setSenderName(userService.findById(message.getUser().getUserId()).getName());
			displayedMessages.add(fetchedMessage);
		}
		return displayedMessages;
	}
}
