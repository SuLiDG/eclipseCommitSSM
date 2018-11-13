package com.df.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.df.ssm.entity.RoleInfo;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

//    @ResultMap("BaseResultMap")
    @Results({
    	@Result(column="ROLE_ID",property="roleId",id=true),
    	@Result(column="ROLE_NAME",property="roleName")
    })
    @Select("SELECT * FROM ROLE_INFO ORDER BY ROLE_ID")
    List<RoleInfo> selectAll();
}