/**
 * AccountController.java
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.seata.entity.Account;
import com.evmtv.seata.service.AccountService;

import util.ResponseUtil;

import java.math.BigDecimal;
 
@RestController
public class AccountController {
 
    @Resource
    AccountService accountService;
 
    /**
     * 扣减账户余额
     */
    @PostMapping("/account/decrease")
    public ResponseUtil<Account> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
    	
        accountService.decrease(userId,money);
        return new ResponseUtil<Account>().result(ResponseUtil.SUCCESS,"扣减账户余额成功！");
    }
}
