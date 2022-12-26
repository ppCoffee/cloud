/**
 * PaymentMapper.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.payment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import entity.Payment;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment>{

}
