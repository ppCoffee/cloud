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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.evmtv.common.entity.Payment;
import com.evmtv.common.util.ResultHelper;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {

	@GetMapping("/get/{id}")
	public ResultHelper<Payment> get(@PathVariable long id);
	
	@PostMapping("/save")
	public ResultHelper<Payment> save(@RequestBody  Payment payment);
	
	@GetMapping("/timeout")
	public ResultHelper<String> timeout();
	
}