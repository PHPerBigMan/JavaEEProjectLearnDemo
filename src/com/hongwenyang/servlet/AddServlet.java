package com.hongwenyang.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hongwenyang.dao.impl.StudentServiceImpl;
import com.hongwenyang.domain.Student;
import com.hongwenyang.service.StudentService;

/**
 * Servlet implementation class AddServlet
 * 新增学生
 */
public class AddServlet extends HttpServlet {
	
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
		hobbys = hobbys.substring(1, hobbys.length()-1);
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-DD").parse(birthday);
			Student student = new Student(sname, gender, phone, hobbys, info, date);
			service.insert(student);
			request.getRequestDispatcher("StudentServlet").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		// 目前这里我还没有看视频自己写的不知道合不合理
//		try {
//			List<Student> list =  service.findAll();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("list.jsp").forward(request, response);
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
