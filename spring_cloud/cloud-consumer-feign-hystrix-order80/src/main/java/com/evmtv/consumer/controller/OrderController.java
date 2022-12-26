/**
 * OrderController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.consumer.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.consumer.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //全局的
@RestController
public class OrderController {

    @Resource
    private OrderService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
    	
        return paymentService.paymentInfo_OK(id);
    }
    
//    @HystrixCommand(fallbackMethod = "payment_timeout_handler",commandProperties = {
//    		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "1500")
//    })
    @HystrixCommand //全局配置所需要注解
    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id){
    	
    	int i = 10/0;
    	
        return paymentService.paymentInfo_TimeOut(id);
    }
    
    //兜底方法
    public String payment_timeout_handler(@PathVariable Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }
    
    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
    

    
}
