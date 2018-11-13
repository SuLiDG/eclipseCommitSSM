package com.df.ssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.df.ssm.commons.SnowflakeId;
import com.df.ssm.entity.UserInfo;
import com.df.ssm.exception.CodeException;
import com.df.ssm.mapper.UserInfoMapper;
import com.df.ssm.service.UserInfoService;
import com.df.ssm.vo.UserInfoVO;
import com.df.ssm.vo.UserSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private SnowflakeId id;
	
	@Override
	public PageInfo<UserInfo> page(UserSearch search) {
		log.info("分页条件：{}", JSON.toJSONString(search));
		return PageHelper.startPage(search.getPage(), search.getRowMax()).doSelectPageInfo(()->userInfoMapper.page(search));
	}

	@Override
	public UserInfoVO get(Long id) {
		return userInfoMapper.getUserVO(id);
	}

	@Override
	public void add(UserInfo userInfo) {
		if(userInfoMapper.selectByName(userInfo.getName())!=null){
			throw new CodeException(3);
		}
		userInfo.setId(id.nextId());
		userInfo.setCreateTime(new Date());
		userInfoMapper.insertSelective(userInfo);
	}

	@Override
	public void delete(Long id) {
		userInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updatePwd(Long id, String pwd) {
		UserInfo entity = new UserInfo();
		entity.setId(id);
		entity.setPwd(pwd);
		userInfoMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void update(UserInfo userInfo) {
		userInfo.setName(null);
		userInfo.setRealName(null);
		userInfo.setPwd(null);
		userInfo.setCreateTime(null);
		userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	
}
