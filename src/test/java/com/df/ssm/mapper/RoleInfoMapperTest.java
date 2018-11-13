package com.df.ssm.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.df.ssm.TestSupport;

public class RoleInfoMapperTest extends TestSupport {

	@Autowired
	private RoleInfoMapper mapper;
	
	@Test
	public void test1(){
		logger.info(JSON.toJSONString(mapper.selectAll()));
	}
}
