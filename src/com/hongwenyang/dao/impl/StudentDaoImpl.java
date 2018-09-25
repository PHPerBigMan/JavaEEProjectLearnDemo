package com.hongwenyang.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hongwenyang.dao.StudentDao;
import com.hongwenyang.domain.Student;
import com.hongwenyang.util.JDBCUtil02;
import com.hongwenyang.util.TextUtil;
/*
 * 实现StudentDao
 */
public class StudentDaoImpl implements StudentDao {
	QueryRunner cQueryRunner ;
	public StudentDaoImpl() {
		cQueryRunner = new QueryRunner(JDBCUtil02.getDataSource());
	}
	
	public List<Student> findAll() throws SQLException {
		QueryRunner cQueryRunner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		// 这里我需要强转，还需要想一下为什么 。错误原因：前面我用的是List接收，后面居然用的不是List
		List<Student> list = cQueryRunner.query(sql, new BeanListHandler<Student>(Student.class));

		return list;
	}

	public void insert(Student student) throws SQLException {
		QueryRunner cQueryRunner = new QueryRunner(JDBCUtil02.getDataSource());getClass();
		cQueryRunner.update("insert into stu values(null,?,?,?,?,?,?)", 
				student.getSname(),
				student.getGender(),
				student.getBirthday(),
				student.getPhone(),
				student.getHobby(),
				student.getInfo()
				);
	}

	public void del(int id) throws SQLException {
		cQueryRunner.update("delete from stu where id = ?", id);
	}

	public Student findFirst(int id) throws SQLException {
		return cQueryRunner.query("select * from stu where id = ?", new BeanHandler<Student>(Student.class),id);
	}

	// 更新
	public void update(Student student) throws SQLException {
		cQueryRunner.update("update stu set sname=?,gender=?,birthday=?,phone=?,hobby=?,info=? where id =?",
				student.getSname(),
				student.getGender(),
				student.getBirthday(),
				student.getPhone(),
				student.getHobby(),
				student.getInfo(),
				student.getId()
				);
	}
	// 更新2
	public void updateWithid(int id,Student student) throws SQLException {
		cQueryRunner.update("update stu set sname=?,gender=?,birthday=?,phone=?,hobby=?,info=? where id =?",
				student.getSname(),
				student.getGender(),
				student.getBirthday(),
				student.getPhone(),
				student.getHobby(),
				student.getInfo(),
				id
				);
	}

	public List<Student> findWithSearch(String name) throws SQLException {
		
		return cQueryRunner.query("select * from stu where sname like ?", new BeanListHandler<Student>(Student.class),"%"+name+"%");
	}

	// 模糊搜索,根据查询的关键词进行数据的查询
	public List<Student> findWithSearchs(String name, String gender) throws SQLException {
		String sql = "select * from stu where 1=1";
		List<String> pList = new ArrayList<String>();
		if(!TextUtil.isEmpty(name)) {
			sql = sql + " and sname like ?";
			// 在传入的数据前后添加 %
			pList.add("%"+name+"%");
		}
		
		if(!TextUtil.isEmpty(gender)) {
			sql = sql + " and gender = ?";
			pList.add(gender);
		}
		return cQueryRunner.query(sql, new BeanListHandler<Student>(Student.class),pList.toArray());
	}

	// 分页
	public List<Student> findWithPage(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
		return cQueryRunner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class),PAGE_LIMIT,(currentPage - 1)*PAGE_LIMIT);
		
	}

	public int findCount() throws SQLException {
		Long number = (Long) cQueryRunner.query("select count(*) from stu",new ScalarHandler());
		return number.intValue() ;
	}

}
