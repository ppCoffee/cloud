/**
 * OrderService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.evmtv.seata.entity.Order;

public interface OrderService extends IService<Order>{

	/**
	 * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
	 */
	void create(Order order);

}
