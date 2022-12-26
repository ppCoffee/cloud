/**
 * PaymentController.java
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.payment.service.PaymentService;

import entity.Payment;
import util.ResultHelper;

@RestController
public class PaymentController {
	
	@Resource
	PaymentService paymentService;
	
	@GetMapping("/get/{id}")
	public ResultHelper<Payment> get(@PathVariable Long id){
		
		Payment payment = paymentService.getById(id);
		
		return ResultHelper.result(ResultHelper.SUCCESS, ResultHelper.SUCCESS_MESSAGE, payment);
	}
	
	@PostMapping("/save")
	public ResultHelper<Payment> save(@RequestBody Payment payment){
		
		boolean success = paymentService.save(payment);
		if(success)
			return ResultHelper.result(ResultHelper.SUCCESS, ResultHelper.SUCCESS_MESSAGE + " id " + payment.getId());
		
		return ResultHelper.result(ResultHelper.FAILED, ResultHelper.FAILED);
	}
	
}
