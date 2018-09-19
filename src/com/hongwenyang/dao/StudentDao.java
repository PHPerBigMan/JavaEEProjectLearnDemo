package com.hongwenyang.dao;

import java.sql.SQLException;
import java.util.List;

import com.hongwenyang.domain.Student;

/*
 * 
 * 学生表的数据库操作 导包 ctrl+shift+o
 */
public interface StudentDao {
	/*
	 * 返回所有学生数据
	 */
	List<Student> findAll ()throws SQLException;
}
