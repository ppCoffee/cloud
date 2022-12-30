/**
 * OrderController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evmtv.seata.entity.Order;
import com.evmtv.seata.service.OrderService;

import util.ResponseUtil;

import javax.annotation.Resource;


@RestController
public class OrderController{
   @Resource
   private OrderService orderService;


   @GetMapping("/order/create")
   public ResponseUtil<Order> create(Order order)
   {
       orderService.create(order);
       return new ResponseUtil<Order>().result("200","订单创建成功");
   }
}