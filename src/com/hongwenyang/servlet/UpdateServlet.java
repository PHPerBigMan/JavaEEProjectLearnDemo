package com.hongwenyang.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongwenyang.dao.impl.StudentServiceImpl;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone  = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String[] hobby = request.getParameterValues("hobby");
		String info = request.getParameter("info");
		StudentService service = new StudentServiceImpl();
		String hobbys = Arrays.toString(hobby);
		int id  = Integer.parseInt(request.getParameter("id"));
		hobbys = hobbys.substring(1, hobbys.length()-1);
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-DD").parse(birthday);
			Student student = new Student(id,sname, gender, phone, hobbys, info, date);
			service.updateWithid(id,student);
			request.getRequestDispatcher("StudentServlet").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
