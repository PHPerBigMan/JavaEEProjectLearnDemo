package com.hongwenyang.service;

import java.sql.SQLException;
import java.util.List;

import com.hongwenyang.domain.Student;

public interface StudentService {
	List<Student> findAll ()throws SQLException;
	
	void insert(Student student) throws SQLException; 
	
	void del(int id) throws SQLException;
	
	Student findFirst(int id) throws SQLException;
	
	void update(Student student) throws SQLException;
	
	void updateWithid(int id,Student student) throws SQLException;
	
	List<Student> findWithSearch (String name)throws SQLException;
	
	List<Student> findWithSearchs (String name,String gender)throws SQLException;
}
