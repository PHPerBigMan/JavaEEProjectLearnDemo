package com.hongwenyang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hongwenyang.dao.StudentDao;
import com.hongwenyang.domain.PageBean;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;
// 涓氬姟閫昏緫
public class StudentServiceImpl implements StudentService {

	public List<Student> findAll() throws SQLException {
		
		StudentDao studentDao = new StudentDaoImpl();
		
		return studentDao.findAll();
	}

	public void insert(Student student) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		
		studentDao.insert(student);
	}

	public void del(int id) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		
		studentDao.del(id);
	}

	public Student findFirst(int id) throws SQLException {
		StudentDao sDao = new StudentDaoImpl();
		return sDao.findFirst(id);
	}

	public void update(Student student) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		
		studentDao.update(student);
	}

	public void updateWithid(int id, Student student) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateWithid(id, student);
	}

	public List<Student> findWithSearch(String name) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findWithSearch(name);
	}

	public List<Student> findWithSearchs(String name, String gender) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findWithSearchs(name, gender);
	}

	
	// 分页数据
	public PageBean<Student> findWithPage(int currentPage) throws SQLException {
		int count = new StudentDaoImpl().findCount();
		int pageSize = StudentDao.PAGE_LIMIT ;
		int allPageCount = count%pageSize == 0 ? count/pageSize : count/pageSize + 1;

		if(allPageCount < currentPage) {
			currentPage = allPageCount;
		}
		if(currentPage <=0) {
			currentPage = 1;
		}
		PageBean<Student> pBean = new PageBean<Student>();
		pBean.setCurrentPage(currentPage);
		pBean.setCurrentCount(StudentDao.PAGE_LIMIT);
		pBean.setList(new StudentDaoImpl().findWithPage(currentPage));
		// 总数和总页数
		pBean.setCount(count);
		pBean.setCountPage(allPageCount);
		return pBean;
	}

}
