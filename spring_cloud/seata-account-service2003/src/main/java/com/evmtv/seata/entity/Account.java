/**
 * Account.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Account {
 
    private Long id;
 
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;
 
    /**
     * 总额度
     */
    private BigDecimal total;
 
    /**
     * 已用额度
     */
    private BigDecimal used;
 
    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
