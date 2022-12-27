/**
 * MessageController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月27日
 */

package com.evmtv.stream.message;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@SuppressWarnings("deprecation")
@Component
@EnableBinding(Sink.class)
public class ReceiveMessage {
	
	
	@Value("${server.port}")
	private String serverPort;
	
	@StreamListener(Sink.INPUT)
	public void receive(Message<String> message) {
		
		System.out.println("serverPort " + serverPort + " message => " + message);
	}
}
