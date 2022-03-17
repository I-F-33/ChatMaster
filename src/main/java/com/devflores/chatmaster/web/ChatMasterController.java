package com.devflores.chatmaster.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devflores.chatmaster.domain.Channel;
import com.devflores.chatmaster.domain.Message;
import com.devflores.chatmaster.domain.User;
import com.devflores.chatmaster.dto.MessageDTO;
import com.devflores.chatmaster.service.ChannelService;
import com.devflores.chatmaster.service.MessageService;
import com.devflores.chatmaster.service.UserService;

@Controller
public class ChatMasterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/welcome")
	public String displayWelcomePage(ModelMap model) {
		 if (channelService.findAll().size() == 0) {
			 channelService.createGeneralChannel();
		 }
		 model.addAttribute("channels", channelService.findAll());
		 model.addAttribute("channel", new Channel());
		return "welcome";
	}
	
	@PostMapping("/welcome/createNewUser")
	@ResponseBody
	public User postUserToDatabase (@RequestBody String userName) {
		return userService.createNewUser(userName);
		
	}
	
	@PostMapping("/welcome/createNewChannel")
	public String createNewChannel(Channel channel) {
		channelService.addChannel(channel);
		return "redirect:/welcome";
	}
	
	@GetMapping("/channel/{channelId}")
	public String loadChannel (@PathVariable Integer channelId) {
	
		return "channel";
	}
	
	
	@GetMapping("/channel/{channelId}/getMessages")
	@ResponseBody
	public List<MessageDTO> fetchAllMessages(@PathVariable Long channelId) {
		return messageService.findAllByChannelId(channelId);
	}
	
	@PostMapping("/channel/{channelId}/createMessage")
	public @ResponseBody Message createNewMessage(@RequestBody MessageDTO message) {
	 return messageService.createMessage(message);
	}
}
