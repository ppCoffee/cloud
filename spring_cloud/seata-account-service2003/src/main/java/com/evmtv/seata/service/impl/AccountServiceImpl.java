/**
 * AccountServiceImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evmtv.seata.entity.Account;
import com.evmtv.seata.mapper.AccountMapper;
import com.evmtv.seata.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService{
	
	@Resource
	AccountMapper accountMapper;
	
	@Override
	public void decrease(Long userId, BigDecimal money) {
		
       log.info("------->account-service中扣减账户余额开始");
       try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
       
       QueryWrapper<Account> queryWrapper = new QueryWrapper<Account>();
	   queryWrapper.eq("user_id", userId);
	   Account account = accountMapper.selectOne(queryWrapper);
	   
	   account.setUsed(account.getUsed().add(money));
	   account.setResidue(account.getResidue().subtract(money));
	   accountMapper.updateById(account);
       
       log.info("------->account-service中扣减账户余额结束");
		
	}

}
