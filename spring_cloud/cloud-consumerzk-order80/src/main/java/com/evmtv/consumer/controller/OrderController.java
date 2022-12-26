/**
 * OrderController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {
	
public static final String PAYMNET_URL = "http://cloud-provider-payment";
	
	@Resource
	RestTemplate restTemplate;
	
	
	@GetMapping("/consumer/zk")
	public String zk(){
		
		return restTemplate.getForObject(PAYMNET_URL + "/zk", String.class);
	}
}
