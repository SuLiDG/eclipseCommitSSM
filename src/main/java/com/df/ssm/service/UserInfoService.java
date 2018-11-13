package com.df.ssm.service;

import com.df.ssm.entity.UserInfo;
import com.df.ssm.vo.UserInfoVO;
import com.df.ssm.vo.UserSearch;
import com.github.pagehelper.PageInfo;

public interface UserInfoService {

	PageInfo<UserInfo> page(UserSearch search);

	UserInfoVO get(Long id);

	void add(UserInfo userInfo);

	void delete(Long id);

	void updatePwd(Long id, String pwd);

	void update(UserInfo userInfo);
	
}
