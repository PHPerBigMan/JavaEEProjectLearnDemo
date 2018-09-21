package com.hongwenyang.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongwenyang.dao.impl.StudentServiceImpl;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;

/**
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		request.setCharacterEncoding("UTF-8");
		String name 	= request.getParameter("sname");
		String gender 	= request.getParameter("sgender");
		try {
			// 模糊查询1
			List<Student> sList = service.findWithSearchs(name, gender);
			// 模糊查询2
//			List<Student> sList = service.findWithSearch(name);
			request.setAttribute("list", sList);
			request.setAttribute("sname", name);
			request.setAttribute("gender", gender);
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
