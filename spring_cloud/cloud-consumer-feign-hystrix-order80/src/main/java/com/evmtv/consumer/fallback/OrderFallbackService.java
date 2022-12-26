/**
 * OrderFallbackService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月27日
 */

package com.evmtv.consumer.fallback;

import org.springframework.stereotype.Component;

import com.evmtv.consumer.service.OrderService;


/**
 * 对端宕了才生效，如果是内部异常无法捕获
 * @author Administrator
 *
 */
@Component
public class OrderFallbackService implements OrderService{

	@Override
	public String paymentInfo_OK(Integer id) {
		return "Global paymentInfo_OK fallback";
	}

	@Override
	public String paymentInfo_TimeOut(Integer id) {
		return "Global paymentInfo_TimeOut fallback";
	}

}
