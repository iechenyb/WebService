<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String basePath = "http://" + request.getServerName() + ":"
		+ request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>default</title>
</head>
<body>
   <a href='<%=basePath%>services/' target='_self'>xfire Services</a>
   <a href='<%=basePath%>XFireEnter/' target='_self'>invoke xfire Services</a>
   
</body>
</html>