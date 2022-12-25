/**
 * HystrixContoller.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月24日
 */



package com.evmtv.payment.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.payment.service.impl.HystrixServiceImpl;

@RestController
public class HystrixContoller {
	
	@Resource
	HystrixServiceImpl hystrixServiceImpl;
	
	@GetMapping("/payment_ok/{id}")
	public String payment_ok(@PathVariable Integer id) {
		
		return hystrixServiceImpl.payment_ok(id);
	}
	
	@GetMapping("/payment_timeout/{id}")
	public String payment_timeout(@PathVariable Integer id) {
		
		return hystrixServiceImpl.payment_timeout(id);
	}
	
	@GetMapping("/circuitBreaker/{id}")
	public String circuitBreaker(@PathVariable Integer id) {
		
		return hystrixServiceImpl.circuitBreaker(id);
	}
}
