package com.hongwenyang.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongwenyang.dao.impl.StudentServiceImpl;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		
		try {
			Student sdata = service.findFirst(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("stu", sdata);
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
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
