package com.hongwenyang.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hongwenyang.dao.StudentDao;
import com.hongwenyang.domain.Student;
import com.hongwenyang.util.JDBCUtil02;
/*
 * ʵ��StudentDao
 */
public class StudentDaoImpl implements StudentDao {
	
	public List<Student> findAll() throws SQLException {
		QueryRunner cQueryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		// ��������Ҫǿת������Ҫ��һ��Ϊʲô ������ԭ��ǰ�����õ���List���գ������Ȼ�õĲ���List
		List<Student> list = cQueryRunner.query(sql, new BeanListHandler<Student>(Student.class));
//		return ;
//		List<Student> list  = cQueryRunner.query(sql, new BeanHandler<Student>(Student.class));
		return list;
	}

}
