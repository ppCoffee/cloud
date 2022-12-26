/**
 * PaymentService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import entity.Payment;
import util.ResultHelper;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

	@GetMapping("/get/{id}")
	public ResultHelper<Payment> get(@PathVariable Long id);
	
	@GetMapping("/timeout")
	public String paymentFeignTimeout();
}
