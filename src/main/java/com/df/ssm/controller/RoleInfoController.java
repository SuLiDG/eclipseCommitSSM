package com.df.ssm.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.df.ssm.entity.RoleInfo;
import com.df.ssm.service.RoleInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author J.L.Zhou
 * @since 2018-11-04
 */
@Controller
@RequestMapping("/role")
public class RoleInfoController {

	@Autowired
	private RoleInfoService service;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public List<RoleInfo> doList(){
		return service.listAll();
	}
	
	
}

