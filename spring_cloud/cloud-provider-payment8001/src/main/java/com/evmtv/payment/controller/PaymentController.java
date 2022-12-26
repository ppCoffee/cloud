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

import java.util.List;
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

import com.evmtv.payment.service.PaymentService;

import entity.Payment;
import lombok.extern.slf4j.Slf4j;
import util.ResultHelper;

@Slf4j
@RestController
public class PaymentController {
	
	@Resource
	PaymentService paymentService;
	
	@Value("${server.port}")
	private String serverPort;
	
	@Resource
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/get/{id}")
	public ResultHelper<Payment> get(@PathVariable Long id){
		
		Payment payment = paymentService.getById(id);
		
		return ResultHelper.result(ResultHelper.SUCCESS, ResultHelper.SUCCESS_MESSAGE + " serverPort: " + serverPort, payment);
	}
	
	@PostMapping("/save")
	public ResultHelper<Payment> save(@RequestBody Payment payment){
		
		boolean success = paymentService.save(payment);
		if(success)
			return ResultHelper.result(ResultHelper.SUCCESS, ResultHelper.SUCCESS_MESSAGE + " id " + payment.getId());
		
		return ResultHelper.result(ResultHelper.FAILED, ResultHelper.FAILED);
	}

	 
	@GetMapping("/discovery")
	public Object discovery(){
	    List<String> services = discoveryClient.getServices();
	    for (String element : services) {
	        log.info("***** element:"+element);
	    }
	    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
	    for (ServiceInstance instance : instances) {
	        log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
	    }
	    return this.discoveryClient;
	}
	
	@GetMapping(value = "/timeout")
	public String paymentFeignTimeout(){
	    try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
	    return serverPort;
	}
	
}
