/**
 * OrderSericeImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evmtv.seata.entity.Order;
import com.evmtv.seata.mapper.OrderMapper;
import com.evmtv.seata.service.AccountService;
import com.evmtv.seata.service.OrderService;
import com.evmtv.seata.service.StorageService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderSericeImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{
	
	
	@Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
 
    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order){
        log.info("----->开始新建订单");
        //新建订单
        orderMapper.insert(order);
 
        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");
 
        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");
 
         
        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.updateById(order);
//        orderMapper.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");
 
        log.info("----->下订单结束了");
 
    }


}
