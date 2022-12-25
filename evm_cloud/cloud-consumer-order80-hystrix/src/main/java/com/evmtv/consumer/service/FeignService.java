/**
 * FeignService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月23日
 */



package com.evmtv.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.evmtv.consumer.exception.FallbackService;


@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = FallbackService.class)
public interface FeignService {

	@GetMapping("/payment_ok/{id}")
	public String payment_ok(@PathVariable Integer id);
		
	
	@GetMapping("/payment_timeout/{id}")
	public String payment_timeout(@PathVariable Integer id);
	
}