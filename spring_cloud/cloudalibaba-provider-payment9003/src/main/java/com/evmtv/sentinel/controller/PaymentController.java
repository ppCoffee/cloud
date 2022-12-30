/**
 * PaymentController.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月30日
 */

package com.evmtv.sentinel.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entity.Payment;
import util.ResultHelper;

import java.util.HashMap;


@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static{
        hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public ResultHelper<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        ResultHelper<Payment> result = ResultHelper.result(ResultHelper.SUCCESS,ResultHelper.SUCCESS_MESSAGE + " from mysql,serverPort:  " + serverPort,payment);
        return result;
    }



}