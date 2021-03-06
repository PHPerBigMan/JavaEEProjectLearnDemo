package com.hongwenyang.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongwenyang.dao.StudentDao;
import com.hongwenyang.dao.impl.StudentDaoImpl;
import com.hongwenyang.dao.impl.StudentServiceImpl;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;

/**
 * 负责查询所有的学生信息 呈现至jsp页面
 */
public class StudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> sList = service.findAll();
			
			request.setAttribute("list", sList);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
