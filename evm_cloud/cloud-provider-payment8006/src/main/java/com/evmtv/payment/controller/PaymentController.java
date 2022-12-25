/**
 * PaymentController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月21日
 */

package com.evmtv.payment.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.common.entity.Payment;
import com.evmtv.common.util.ResultHelper;


@RestController
public class PaymentController {

	@Resource
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/consul")
	public ResultHelper<Payment> consul() {

		return ResultHelper.result(ResultHelper.SUCCESS + " user port " + serverPort, ResultHelper.SUCCESS_MESSAGE);

	}

}
