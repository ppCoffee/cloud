/**
 * MessageController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月27日
 */

package com.evmtv.stream.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.stream.service.MessageService;

@RestController
public class MessageController {
	
	@Resource
	MessageService messageService;
	
	@GetMapping("/send")
	public boolean send() {
		
		return messageService.send();
	}
}
