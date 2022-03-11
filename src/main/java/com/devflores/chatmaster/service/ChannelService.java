package com.devflores.chatmaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devflores.chatmaster.domain.Channel;
import com.devflores.chatmaster.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	public Channel createGeneralChannel() {
		Channel generalChannel = new Channel();
		generalChannel.setChannelName("General");
		return channelRepo.save(generalChannel);
	}
	
	public Channel addChannel(Channel channel) {
		return channelRepo.save(channel);
	}
	
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel findById(Long ChannelId) {
		return channelRepo.findById(ChannelId).get();
	}
}
