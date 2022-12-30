/**
 * StorageServiceImpl.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月31日
 */

package com.evmtv.seata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.evmtv.seata.entity.Storage;
import com.evmtv.seata.mapper.StorageMapper;
import com.evmtv.seata.service.StorageService;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService{

	@Resource
	StorageMapper storageMapper;
	
	
	@Override
	public void decrease(Long productId, Integer count) {
		
		QueryWrapper<Storage> queryWrapper = new QueryWrapper<Storage>();
		queryWrapper.eq("product_id", productId);
		Storage storage = storageMapper.selectOne(queryWrapper);
		
		storage.setUsed(storage.getUsed() + count);
		storage.setResidue(storage.getResidue() - count);
		
		storageMapper.updateById(storage);
	}

}
