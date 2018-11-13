package com.df.ssm.vo;

import com.df.ssm.entity.UserInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserInfoVO extends UserInfo {
	
	private String roleName;
	
}
