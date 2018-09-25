<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>

<body>
<form action="SearchStudentServlet" method="post">
	<table border="1" width="700" style="text-align: center;">
		<tr >
				<td colspan="8">
					
					按姓名查询:<input type="text" name="sname" value="${sname }"/>
					&nbsp;
					按性别查询:<select name="sgender">
								<option value="">--请选择--
								<option value="男" <c:if test="${gender == '男' }">selected</c:if>>男
								<option value="女" <c:if test="${gender == '女' }">selected</c:if>>女
							  </select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
				</td>
		</tr>
		<tr colspan="8">
			<td><a href="add.jsp">添加</a></td>
		</tr>
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>手机</td>
			<td>年级</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.list }" var="v">
		<tr>
			<td>${v.id }</td>
			<td>${v.sname }</td>
			<td>${v.phone }</td>
			<td>${v.gender }</td>
			<td>${v.birthday }</td>
			<td>${v.hobby }</td>
			<td>${v.info }</td>
			<td><a href="EditServlet?id=${v.id }">编辑</a> <a href="#" onclick="doDel(${v.id })">删除</a></td>
		</tr>
		</c:forEach>
		 <tr>
			  	<td colspan="8">
			  		第 ${pageBean.currentPage } / ${pageBean.countPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.currentCount }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.count } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="StudentPageServlet?currentPage=1">首页</a>
						| <a href="StudentPageServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.countPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="StudentPageServlet?currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.countPage }">
			  			<a href="StudentPageServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="StudentPageServlet?currentPage=${pageBean.countPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
	</table>
</form>
</body>
<script>
	function doDel(id){
		var flag = confirm("是否删除");
		if(flag){
			console.log(1);
			location.href="DelServlet?id="+id
		}else{
			
		} 
		console.log(1)
	}
</script>
</html>