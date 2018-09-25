package com.hongwenyang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongwenyang.dao.impl.StudentServiceImpl;
import com.hongwenyang.domain.PageBean;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;

/**
 * Servlet implementation class StudentPageServlet
 */
public class StudentPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		StudentService studentService  = new StudentServiceImpl();
		try {
			PageBean<Student> pageBean = studentService.findWithPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
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
