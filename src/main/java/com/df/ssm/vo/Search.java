package com.df.ssm.vo;

import lombok.Data;

/**
 * 分页查询基础条件
 * @author J.L.Zhou
 *
 */
@Data
public class Search {

	private Integer page=1;
	private Integer rowMax=10;
}
