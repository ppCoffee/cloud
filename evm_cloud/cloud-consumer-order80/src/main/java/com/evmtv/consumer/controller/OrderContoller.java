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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.evmtv.common.entity.Payment;
import com.evmtv.common.util.ResultHelper;
import com.evmtv.consumer.lb.impl.ILoadBlance;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@SuppressWarnings("unchecked")
public class OrderContoller {
	
	//测试用
	//private static final String PAYMNET_ADDRESS = "http://127.0.0.1:8001";
	
	private static final String PAYMNET_ADDRESS = "http://CLOUD-PAYMENT-SERVICE";
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private DiscoveryClient discoveryClient;
	
	@Resource
	private ILoadBlance LoadBlanceImpl;

	@GetMapping("/consumer/save")
	public ResultHelper<Payment> save(Payment payment) {
		
		log.info(payment.toString());
		
		return restTemplate.postForObject(PAYMNET_ADDRESS + "/save",payment, ResultHelper.class); 
	}

	@GetMapping("/consumer/get/{id}")
	public ResultHelper<Payment> get(@PathVariable long id) {
		
		return restTemplate.getForObject(PAYMNET_ADDRESS + "/get/" + id, ResultHelper.class);
	}
	
	@GetMapping("/consumer/getByMylb/{id}")
	public ResultHelper<Payment> getByMylb(@PathVariable long id) {
		
		String uri = LoadBlanceImpl.roundBlance("CLOUD-PAYMENT-SERVICE");
		
		return restTemplate.getForObject(uri + "/get/" + id, ResultHelper.class);
	}
	
	
	
	@GetMapping("/consumer/discoveryClient")
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
