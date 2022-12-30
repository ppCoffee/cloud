/**
 * StorageService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import util.ResponseUtil;

@SuppressWarnings("rawtypes")
@LoadBalancerClient(name = "seata-storage-service")
@FeignClient(value = "seata-storage-service")
public interface StorageService{
	
    @PostMapping(value = "/storage/decrease")
    ResponseUtil decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
