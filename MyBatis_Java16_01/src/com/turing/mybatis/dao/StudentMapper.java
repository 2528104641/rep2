package com.turing.mybatis.dao;
/**
 * 学生接口
 * @author fred
 *
 */

import com.turing.mybatis.entity.Student;

public interface StudentMapper {

	//根据id查询学生
	Student getStuById(Integer id);
}
