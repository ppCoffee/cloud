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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.common.entity.Payment;
import com.evmtv.common.util.ResultHelper;
import com.evmtv.consumer.service.FeignService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderContoller {
	
	
	@Resource
	private FeignService feignService;
	


	@GetMapping("/consumer/get/{id}")
	public ResultHelper<Payment> get(@PathVariable long id) {
		
		ResultHelper<Payment> payment = feignService.get(id);
		
		log.info(payment.toString());
		
		return payment;
	}
	
	@GetMapping("/consumer/save")
	public ResultHelper<Payment> save(Payment payment) {
		
		return feignService.save(payment);
	}
	
	@GetMapping("/consumer/timeout")
	public ResultHelper<String> timeout() {
		
		return feignService.timeout();
	}
	
}
