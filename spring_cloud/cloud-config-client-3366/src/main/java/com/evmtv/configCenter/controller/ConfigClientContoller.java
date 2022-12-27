/**
 * ConfigClientContoller.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月27日
 */

package com.evmtv.configCenter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientContoller {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${config}")
	private String serverConfig;
	
	@GetMapping("/configInfo")
	public String getConfigInfo() {
		
		return serverConfig + "\t\n\n" + " serverPort:" + serverPort;
	}
	
	
}
