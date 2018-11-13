package com.df.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.df.ssm.entity.UserInfo;
import com.df.ssm.vo.UserInfoVO;
import com.df.ssm.vo.UserSearch;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    UserInfoVO getUserVO(@Param("id") Long id);
    
    @ResultMap("BaseResultMap")
    @Select("SELECT * FROM USER_INFO WHERE NAME=#{name}")
    UserInfo selectByName(@Param("name") String name);
    
//    List<UserInfo> select(UserSearch search);

	List<UserInfo> page(UserSearch search);
}