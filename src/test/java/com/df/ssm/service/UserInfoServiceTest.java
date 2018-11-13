package com.df.ssm.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.df.ssm.TestSupport;
import com.df.ssm.entity.UserInfo;
import com.df.ssm.vo.UserSearch;

public class UserInfoServiceTest extends TestSupport {

	@Autowired
	private UserInfoService service;
	
	@Test
	public void page(){
		Object obj =service.page(new UserSearch());
		logger.debug(JSON.toJSONString(obj));
	}
	
	@Test
	public void get(){
		Object obj =service.get(23087586587181056L);
		logger.debug(JSON.toJSONString(obj));
	}
	
	@Test
	public void add(){
		UserInfo userInfo = new UserInfo();
		userInfo.setName("FuHanXiang");
		service.add(userInfo);
	}
}
