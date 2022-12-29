/**
 * RateLimitController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月30日
 */

package com.evmtv.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.evmtv.sentinel.handler.CustomerBlockHandler;

import entity.Payment;
import util.ResultHelper;

@RestController
public class RateLimitController {
	
	
	@GetMapping("/rateLimit/customerBlockHandler")
	@SentinelResource(value = "customerBlockHandler",
	        blockHandlerClass = CustomerBlockHandler.class,
	        blockHandler = "handlerException2")
	public ResultHelper<Payment> customerBlockHandler()
	{
	    return ResultHelper.result(ResultHelper.SUCCESS,ResultHelper.SUCCESS_MESSAGE +  "按客戶自定义",new Payment(2020L,"serial003"));
	}
}
