package com.df.ssm.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.df.ssm.TestSupport;

public class UserInfoMapperTest extends TestSupport {

	@Autowired
	private UserInfoMapper mapper;
	
	@Test
	public void test1(){
		logger.info(JSON.toJSONString(mapper.selectByName("FuHanXiang")));
	}
}
