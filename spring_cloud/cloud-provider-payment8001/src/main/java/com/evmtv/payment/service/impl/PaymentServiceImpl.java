/**
 * PaymentServiceImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月26日
 */

package com.evmtv.payment.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evmtv.payment.mapper.PaymentMapper;
import com.evmtv.payment.service.PaymentService;

import entity.Payment;

@Service
public class PaymentServiceImpl  extends ServiceImpl<PaymentMapper, Payment> implements PaymentService{

}
