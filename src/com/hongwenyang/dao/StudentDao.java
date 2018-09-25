package com.hongwenyang.dao;

import java.sql.SQLException;
import java.util.List;

import com.hongwenyang.domain.Student;

/*
 * 
 * 学生表的数据库操作 导包 ctrl+shift+o
 */
public interface StudentDao {
	int PAGE_LIMIT = 2;
	// 获取分页数据
	List<Student> findWithPage (int currentPage)throws SQLException;
	/*
	 * 返回所有学生数据
	 */
	List<Student> findAll ()throws SQLException;
	/*
	 * 新增
	 */
	void insert(Student student) throws SQLException; 
	
	void del(int id) throws SQLException;
	
	/*
	 * 获取一条数据
	 */
	Student findFirst(int id) throws SQLException;
	// 更新1
	void update(Student student) throws SQLException;
	// 更新2
	void updateWithid(int id,Student student) throws SQLException;
	// 这个查询是有问题的
	List<Student> findWithSearch (String name)throws SQLException;
	// 模糊查询
	List<Student> findWithSearchs (String name,String gender)throws SQLException;
	
	int findCount()  throws SQLException;
}
