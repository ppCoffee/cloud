/**
 * Storage.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

@Data
public class Storage {
 
    private Long id;
 
    // 产品id
    @TableField(value = "product_id")
    private Long productId;
 
    //总库存
    private Integer total;
 
 
    //已用库存
    private Integer used;
 
  
    //剩余库存
    private Integer residue;
}