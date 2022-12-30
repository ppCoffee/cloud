/**
 * AccountService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service;

import java.math.BigDecimal;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import util.ResponseUtil;

@LoadBalancerClient(name = "seata-account-service")
@SuppressWarnings("rawtypes")
@FeignClient(value = "seata-account-service")
public interface AccountService{
	
    
	@PostMapping(value = "/account/decrease")
    ResponseUtil decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}