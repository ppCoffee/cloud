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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import entity.Payment;
import util.ResultHelper;

@SuppressWarnings("unchecked")
@RestController
public class OrderController {
	
	//public static final String PAYMNET_URL = "http://127.0.0.1:8001";
	public static final String PAYMNET_URL = "http://CLOUD-PAYMENT-SERVICE";
	
	@Resource
	RestTemplate restTemplate;
	
	
	@GetMapping("/consumer/get/{id}")
	public ResultHelper<Payment> get(@PathVariable Long id){
		
		return restTemplate.getForObject(PAYMNET_URL + "/get/" + id, ResultHelper.class);
	}
	
	@GetMapping("/consumer/save")
	public ResultHelper<Payment> get(Payment payment){
		
		return restTemplate.postForObject(PAYMNET_URL + "/save", payment, ResultHelper.class);
	}
	
}
