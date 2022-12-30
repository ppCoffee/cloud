/**
 * PaymentFallbackService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月30日
 */

package com.evmtv.sentinel.feign;

import org.springframework.stereotype.Component;

import com.evmtv.sentinel.service.PaymentService;

import entity.Payment;
import util.ResponseUtil;

@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public ResponseUtil<Payment> paymentSQL(Long id)
    {
        return new ResponseUtil<Payment>().result("44444","服务降级返回---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
 
