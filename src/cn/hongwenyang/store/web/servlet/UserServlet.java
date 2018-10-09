package cn.hongwenyang.store.web.servlet;

import cn.hongwenyang.store.domain.User;
import cn.hongwenyang.store.utils.MyBeanUtils;
import cn.hongwenyang.store.web.base.BaseServlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private Map<String, String[]> parameterMap;
	private User populate;

	public String registerUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	
	
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		parameterMap = request.getParameterMap();
		populate = MyBeanUtils.populate(User.class, parameterMap);
		return "/jsp/register.jsp";
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
