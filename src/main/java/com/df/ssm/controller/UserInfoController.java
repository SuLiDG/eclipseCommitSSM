package com.df.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.df.ssm.entity.UserInfo;
import com.df.ssm.service.UserInfoService;
import com.df.ssm.vo.UserInfoVO;
import com.df.ssm.vo.UserSearch;
import com.github.pagehelper.PageInfo;
import com.df.ssm.R;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("page")
	@ResponseBody
	public PageInfo<UserInfo> page(UserSearch search){
		return userInfoService.page(search);
	}
	
	@RequestMapping("get-{id}")
	@ResponseBody
	public UserInfoVO doGet(@PathVariable("id")Long id){
		return userInfoService.get(id);
	}
	
	@RequestMapping("add")
	@ResponseBody
	public R add(UserInfo userInfo){
		userInfoService.add(userInfo);
		return R.ok();
	}
	
	@RequestMapping("del-{id}")
	@ResponseBody
	public R delete(@PathVariable("id") Long id){
		userInfoService.delete(id);
		return R.ok();
	}
	
	@RequestMapping("pwd")
	@ResponseBody
	public R pwd(Long id,String pwd){
		userInfoService.updatePwd(id, pwd);
		return R.ok();
	}
	
	@RequestMapping("modify")
	@ResponseBody
	public R update(UserInfo userInfo){
		userInfoService.update(userInfo);
		return R.ok();
	}
}

