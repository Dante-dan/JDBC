<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
来自jsp:forward的跳转<br/>
<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	out.println("userName:"+userName);
	out.println("<br/>");
	out.println("password:"+password);
%>
</body>
</html>