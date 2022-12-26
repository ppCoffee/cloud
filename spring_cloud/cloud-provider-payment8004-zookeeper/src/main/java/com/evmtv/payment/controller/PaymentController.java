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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.lang.UUID;

@RestController
public class PaymentController {
	
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
