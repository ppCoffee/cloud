/**
 * Order.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
 
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private Long id;
    
    @TableField(value = "user_id")
    private Long userId;
    
    @TableField(value = "product_id")
    private Long productId;
 
    private Integer count;
 
    private BigDecimal money;
 
    private Integer status; //订单状态：0：创建中；1：已完结
}
