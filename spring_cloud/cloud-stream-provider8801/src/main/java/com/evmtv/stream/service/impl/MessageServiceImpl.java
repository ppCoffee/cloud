/**
 * MessageServiceImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月27日
 */

package com.evmtv.stream.service.impl;


import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.evmtv.stream.service.MessageService;

import cn.hutool.core.lang.UUID;


@SuppressWarnings("deprecation")
@EnableBinding(Source.class)
public class MessageServiceImpl implements MessageService{
	
	@Resource
	private MessageChannel output; //消息管道
	
	@Override
	public boolean send() {
		
		String serial = UUID.randomUUID().toString();
		boolean result = output.send(MessageBuilder.withPayload(serial).build());
		
		return result;
	}
	
	
	
}
