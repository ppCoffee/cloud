/**
 * CustomerBlockHandler.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月30日
 */

package com.evmtv.sentinel.handler;


import com.alibaba.csp.sentinel.slots.block.BlockException;

import entity.Payment;
import util.ResultHelper;

public class CustomerBlockHandler {
	
	//必须是static
	
	public static ResultHelper<Payment> handlerException(BlockException ex) {
		
		return ResultHelper.result(ResultHelper.FAILED, ResultHelper.FAILED_MESSAGE,new Payment(2020L,"handlerException1"));
	}
	
	public static ResultHelper<Payment> handlerException2(BlockException ex) {
		
		return ResultHelper.result(ResultHelper.FAILED, ResultHelper.FAILED_MESSAGE,new Payment(2020L,"handlerException2"));
	}
}
