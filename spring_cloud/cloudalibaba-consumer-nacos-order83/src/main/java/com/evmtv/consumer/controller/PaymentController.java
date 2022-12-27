/**
 * PaymentController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.consumer.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import util.ResultHelper;

@SuppressWarnings("unchecked")
@RestController
public class PaymentController {
	
	
	@Value("${service-url.nacos-user-service}")
	private String uri;
	
	@Resource
	private RestTemplate restTemplate;
	
	
	@GetMapping("/consumer/nacos/{id}")
	public ResultHelper<String> nacos(@PathVariable Long id){
		
		return restTemplate.getForObject(uri + "/nacos/" + id, ResultHelper.class);
	}
	
}
