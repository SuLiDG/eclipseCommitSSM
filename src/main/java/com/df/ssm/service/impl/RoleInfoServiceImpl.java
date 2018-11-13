package com.df.ssm.service.impl;

import com.df.ssm.entity.RoleInfo;
import com.df.ssm.mapper.RoleInfoMapper;
import com.df.ssm.service.RoleInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author J.L.Zhou
 * @since 2018-11-04
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
	
	@Autowired
	private RoleInfoMapper mapper;

	@Override
	public List<RoleInfo> listAll() {
		return mapper.selectAll();
	}

}
