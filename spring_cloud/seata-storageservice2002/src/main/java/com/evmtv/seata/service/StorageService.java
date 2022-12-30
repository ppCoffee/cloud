/**
 * StorageService.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.evmtv.seata.entity.Storage;

public interface StorageService extends IService<Storage>{

	void decrease(Long productId, Integer count);

}
