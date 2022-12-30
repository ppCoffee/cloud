/**
 * CircleBreakerController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月30日
 */

package com.evmtv.sentinel.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.evmtv.sentinel.service.PaymentService;

import entity.Payment;
import util.ResponseUtil;
import util.ResultHelper;

@RestController
public class CircleBreakerController {
   
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;
    
    @Resource
    private PaymentService paymentService;
   
    
    @SuppressWarnings("unchecked")
	@GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public ResultHelper<Payment> fallback(@PathVariable Long id) {
		ResultHelper<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id, ResultHelper.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return result;
    }
  
    //fallback
    public ResultHelper<Payment> handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return ResultHelper.result("444","兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }
  
    //blockHandler
    public ResultHelper<Payment> blockHandler(@PathVariable  Long id,BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return  ResultHelper.result("445","blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public ResponseUtil<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
    
    
}
 
