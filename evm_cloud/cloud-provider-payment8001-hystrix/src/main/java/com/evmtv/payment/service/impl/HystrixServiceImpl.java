/**
 * HystrixServiceImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月24日
 */



package com.evmtv.payment.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

@Service
public class HystrixServiceImpl {
	
	private final static String MAX_WAIT_TIME_IN_MS = "5000"; 
	
	
	public String payment_ok(Integer id) {
		
		return "Thread pool " + Thread.currentThread().getName() + " request_ok => id " + id;
	}
	
	@HystrixCommand(fallbackMethod = "payment_timeout_handler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = MAX_WAIT_TIME_IN_MS)
	})
	public String payment_timeout(Integer id) {
		 
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		if(true) {
//			
//			throw new RuntimeException();
//		}
		
		return "Thread pool " + Thread.currentThread().getName() + " payment_timeout => id " + id;
	}
	
	public String payment_timeout_handler(Integer id) {
		
		return "Thread pool " + Thread.currentThread().getName() + " payment_timeout_handler => id " + id;
	}

	
	@HystrixCommand(fallbackMethod = "circuitBreaker_handler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = MAX_WAIT_TIME_IN_MS), //超时时间
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启熔断
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), //请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //多少时间以内发生异频率
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), //错误率%多少以上触发熔断
	})
	public String circuitBreaker(Integer id) {
		
		if(id <= 0) {
	
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
			}
		
		}
		return "its ok id = " + id + " >> " + IdUtil.simpleUUID();
	}
	
	public String circuitBreaker_handler(Integer id) {
		
		return "do circuitBreaker id = " + id + " >> " + IdUtil.simpleUUID();
	}
}
