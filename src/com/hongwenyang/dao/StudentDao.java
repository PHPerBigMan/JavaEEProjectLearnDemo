package com.hongwenyang.dao;

import java.sql.SQLException;
import java.util.List;

import com.hongwenyang.domain.Student;

/*
 * 
 * ѧ��������ݿ���� ���� ctrl+shift+o
 */
public interface StudentDao {
	int PAGE_LIMIT = 2;
	// ��ȡ��ҳ����
	List<Student> findWithPage (int currentPage)throws SQLException;
	/*
	 * ��������ѧ������
	 */
	List<Student> findAll ()throws SQLException;
	/*
	 * ����
	 */
	void insert(Student student) throws SQLException; 
	
	void del(int id) throws SQLException;
	
	/*
	 * ��ȡһ������
	 */
	Student findFirst(int id) throws SQLException;
	// ����1
	void update(Student student) throws SQLException;
	// ����2
	void updateWithid(int id,Student student) throws SQLException;
	// �����ѯ���������
	List<Student> findWithSearch (String name)throws SQLException;
	// ģ����ѯ
	List<Student> findWithSearchs (String name,String gender)throws SQLException;
	
	int findCount()  throws SQLException;
}
