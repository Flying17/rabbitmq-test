package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.SendTo;

import com.example.demo.stream.MqMessageSource;


@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableBinding(MqMessageSource.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@StreamListener(target =MqMessageSource.ECM_SHOP_TEMPLATE_INPUT, condition = "payload == 20")
    public void enrichLogMessage(int log) {
		System.out.println("enrichLogMessage："+log);
    }
	

	@StreamListener( target =MqMessageSource.ECM_SHOP_TEMPLATE_INPUT, condition = "payload == 10")
    public void enrichLogMessage2(int log) {
		System.out.println("payload："+log);
    }
	
	@StreamListener(MqMessageSource.MESSAGE_OUTPUT)
    public void enrichLogMessage1(String log) {
		System.out.println("enrichLogMessage1:"+log);
    }
}

