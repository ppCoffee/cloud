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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.consumer.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@DefaultProperties(defaultFallback = "globalHandler")
@RestController
public class OrderContoller {
	
	
	@Resource
	private FeignService feignService;
	
	@Value("${server.port}")
	private String serverPort;
	
	private final static String MAX_WAIT_TIME_IN_MS = "1500"; 
	
	@GetMapping("/consumer/payment_ok/{id}")
	public String payment_ok(@PathVariable Integer id) {
		
		return feignService.payment_ok(id);
	}
	
	
//	@HystrixCommand(fallbackMethod = "payment_timeout_handler", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = MAX_WAIT_TIME_IN_MS)
//	})
	//@HystrixCommand
	@GetMapping("/consumer/payment_timeout/{id}")
	public String payment_timeout(@PathVariable Integer id) {
		
		return feignService.payment_timeout(id);
	}
	
	//特殊定制hystrix单独写commandProperties属性
	public String payment_timeout_handler(Integer id) {
		
		return "Thread pool " + Thread.currentThread().getName() + " payment_timeout_handler => id " + id + " port " + serverPort;
	}
	
	//需要@HystrixCommand标签
	public String globalHandler() {
		
		return "Thread pool " + Thread.currentThread().getName() + " global_payment_timeout_handler => serverPort " + serverPort;
	}
	
}
