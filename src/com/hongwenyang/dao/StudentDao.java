package com.hongwenyang.dao;

import java.util.List;

import com.hongwenyang.domain.Student;

/*
 * 
 * ѧ��������ݿ���� ���� ctrl+shift+o
 */
public interface StudentDao {
	/*
	 * ��������ѧ������
	 */
	List<Student> findAll();
}
