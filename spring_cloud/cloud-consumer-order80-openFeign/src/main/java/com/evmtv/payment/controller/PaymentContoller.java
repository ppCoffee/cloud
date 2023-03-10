/**
 * PaymentContoller.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.payment.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.payment.service.PaymentService;

import entity.Payment;
import util.ResultHelper;

@RestController
public class PaymentContoller {
	
	@Resource
	PaymentService paymentService;
	
	@GetMapping("/consumer/get/{id}")
	public ResultHelper<Payment> get(@PathVariable Long id){
		
		return paymentService.get(id);
	}
	
	@GetMapping("/consumer/timeout")
	public String paymentFeignTimeout(){
		
	   return paymentService.paymentFeignTimeout();
	}
	
}
