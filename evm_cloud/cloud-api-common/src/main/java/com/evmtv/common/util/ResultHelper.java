/**
 * ResultUtil.java
 * Copyright(JAVA) EnRich DTV Group co.,Ltd
 * 功能描述：
 *   
 * 创建者：zhangzy@evmtv.com 
 * 编辑者: zhangzy@evmtv.com
 * 2022年12月18日
 */



package com.evmtv.common.util;



import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Data
public class ResultHelper<T> {
	
	public static final String SUCCESS = "1001";
	public static final String SUCCESS_MESSAGE = "success";
	
	public static final String FAILED = "2001";
	public static final String FAILED_MESSAGE = "failed";
	
	public static final String SQL_FAILED = "3001";
	public static final String SQL_FAILED_MESSAGE = "sql failed";
	
	
	
	private T data; 
	
	private String code;
	
	private String message;
	
	public static <T> ResultHelper<T> result(String code, String message, T data) {

		ResultHelper<T> result = new ResultHelper<T>();
		
		if (data != null) {
			result.setData(data);
		}
		
		result.setMessage(message);
		result.setCode(code);

		return result;
	}
	
	public static <T> ResultHelper<T> result(String code, String message) {
		
		return result(code,message,null);
	}

	
}
