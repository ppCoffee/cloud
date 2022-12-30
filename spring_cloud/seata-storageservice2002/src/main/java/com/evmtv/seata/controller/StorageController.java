/**
 * StorageController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.seata.entity.Storage;
import com.evmtv.seata.service.StorageService;

import util.ResponseUtil;

@RestController
public class StorageController {
 
    @Resource
    private StorageService storageService; 
 
 
    //扣减库存
    @PostMapping("/storage/decrease")
    public ResponseUtil<Storage> decrease(Long productId, Integer count) {
    	
        storageService.decrease(productId, count);
        return new ResponseUtil<Storage>().result(ResponseUtil.SUCCESS,"扣减库存成功！");
    }
}