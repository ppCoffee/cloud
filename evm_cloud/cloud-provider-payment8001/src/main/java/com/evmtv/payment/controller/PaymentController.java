/**
 * PaymentController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月21日
 */



package com.evmtv.payment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.common.entity.Payment;
import com.evmtv.common.util.ResultHelper;
import com.evmtv.payment.service.IPaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PaymentController {
	
	@Resource
	private IPaymentService paymentService;
	
	@Resource
	private DiscoveryClient discoveryClient;
	
	
	@Value("${server.port}")
	private String serverPort;
	
	@PostMapping("/save")
	public ResultHelper<Payment> save(@RequestBody  Payment payment) {
		
		log.info(payment.toString());
		
		boolean result = paymentService.save(payment);
		
		if(result) {
			
			log.info("payment id " + payment.getId());
			return ResultHelper.result(ResultHelper.SUCCESS + " user port " + serverPort, ResultHelper.SUCCESS_MESSAGE);
		}else {
			
			return ResultHelper.result(ResultHelper.FAILED + " user port " + serverPort, ResultHelper.FAILED_MESSAGE);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResultHelper<Payment> get(@PathVariable long id) {
		
		Payment payment = paymentService.getById(id);
		
		if(payment != null) {
			
			log.info(payment.toString());
			
			return ResultHelper.result(ResultHelper.SUCCESS  + " user port " + serverPort, ResultHelper.SUCCESS_MESSAGE, payment);
		}else {
			
			return ResultHelper.result(ResultHelper.FAILED  + " user port " + serverPort, ResultHelper.FAILED_MESSAGE);
		}
	}
	
	
	@GetMapping("/timeout")
	public ResultHelper<String> timeout(String content) {
			
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return ResultHelper.result(ResultHelper.SUCCESS  + " user port " + serverPort, ResultHelper.SUCCESS_MESSAGE, new String(content));
	}
	
	@GetMapping("/discoveryClient")
	public ResultHelper<Map<String,Object>> discoveryClient() {
		
		List<String> services = discoveryClient.getServices();
		List<List<ServiceInstance>> instancesList = new ArrayList<List<ServiceInstance>>();
		
		services.forEach(item -> {
			
			List<ServiceInstance> instances = discoveryClient.getInstances(item);
			instancesList.add(instances);
		});
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("services", services);
		map.put("instancesList", instancesList);
		
		return ResultHelper.result(ResultHelper.SUCCESS, ResultHelper.SUCCESS_MESSAGE, map);
	}
	
}
