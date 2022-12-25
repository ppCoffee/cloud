/**
 * OrderContoller.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月21日
 */

package com.evmtv.consumer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.evmtv.common.entity.Payment;
import com.evmtv.common.util.ResultHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@SuppressWarnings("unchecked")
public class OrderContoller {
	
	//测试用
	//private static final String PAYMNET_ADDRESS = "http://127.0.0.1:8001";
	
	private static final String PAYMNET_ADDRESS = "http://cloud-payment-service";
	
	@Resource
	private RestTemplate restTemplate;


	@GetMapping("/consumer/zk")
	public ResultHelper<Payment> get() {
		
		return restTemplate.getForObject(PAYMNET_ADDRESS + "/zk", ResultHelper.class);
	}
}
