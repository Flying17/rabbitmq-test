package com.example.demo.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.stream.MqMessageSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MqReceiver {
	
	@Autowired
	MqMessageSource m;

	@RequestMapping("/a")
	public void a() {
		m.messageInput().send(MessageBuilder.withPayload(10).build());
	}
}