<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="openapi.capcha" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
// 		String key = capcha.getKey();
// 		String tempname = capcha.getImg(key);
// 		request.setAttribute("tempname", tempname);
	%>
	<jsp:forward page="${contextPath}/jsp/login2.jsp"></jsp:forward>
</body>
</html>