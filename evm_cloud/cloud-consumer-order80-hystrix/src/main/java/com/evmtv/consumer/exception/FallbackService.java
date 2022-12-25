/**
 * FallbakService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月24日
 */



package com.evmtv.consumer.exception;

import org.springframework.stereotype.Component;

import com.evmtv.consumer.service.FeignService;

@Component
public class FallbackService implements FeignService
{

	@Override
	public String payment_ok(Integer id) {
		return "do Exception by payment_ok";
	}

	@Override
	public String payment_timeout(Integer id) {
		return "do Exception by payment_timeout";
	}

}
