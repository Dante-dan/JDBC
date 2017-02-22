<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:forward page="login.jsp">
	<jsp:param value="forward" name="userName"/>
	<jsp:param value="jsp" name="password"/>
</jsp:forward>
forward以下的语句不会被执行。