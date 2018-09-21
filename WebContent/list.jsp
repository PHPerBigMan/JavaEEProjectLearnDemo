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
		<c:forEach items="${list }" var="v">
		<tr>
			<td>${v.id }</td>
			<td>${v.sname }</td>
			<td>${v.phone }</td>
			<td>${v.gender }</td>
			<td>${v.birthday }</td>
			<td>${v.hobby }</td>
			<td>${v.info }</td>
			<td><a href="EditServlet?id=${v.id }">编辑</a> <a href="" onclick="doDel(${v.id })">删除</a></td>
		</tr>
		</c:forEach>
		
	</table>
</form>
</body>
<script>
	function doDel(id){
		var flag = confirm("是否删除");
		if(flag){
			location.href="DelServlet?id="+id
		}else{
			
		}
	}
</script>
</html>