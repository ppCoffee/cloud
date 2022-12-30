/**
 * PaymentService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月30日
 */

package com.evmtv.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.evmtv.sentinel.feign.PaymentFallbackService;

import entity.Payment;
import util.ResponseUtil;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService
{
	
    @GetMapping(value = "/paymentSQL/{id}")
    public ResponseUtil<Payment> paymentSQL(@PathVariable("id") Long id); 
}
 