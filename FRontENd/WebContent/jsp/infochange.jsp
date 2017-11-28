<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.diy.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${contextPath}/css/style.css" rel='stylesheet'
	type='text/css' />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="images/fav-icon.png" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<script>
		document.getElementById('opt').setAttribute('value', 'question');
		document.getElementById('searchbar').setAttribute('placeholder','question search...');
	</script>
	<%
		UserVO user = (UserVO) session.getAttribute("user");
		String pwd = request.getParameter("pwd");
		if (!(pwd.equals(user.getPwd()))) {

			request.setAttribute("error", "패스워드 불일치");
			RequestDispatcher rd = request.getRequestDispatcher("userInfo.jsp");
			rd.forward(request, response);

		}
	%>
	<div class="container">
		<div class="body_wrap">
			<div class="signup-div">
				<div class="form-h3">회원 정보 변경</div>
				<div class="signup-form">
					<form id="login-form" action="${contextPath }/userUpdate.do"
						method="post">
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								name="pwd" placeholder="Password">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Name</label> <input
								type="text" class="form-control" id="exampleInputPassword1"
								name="name" placeholder="Name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Nickname</label> <input
								type="text" class="form-control" id="exampleInputPassword1"
								name="nickname" placeholder="Nickname">
						</div>
						<button type="submit" class="btn font-22">변경</button>
					</form>
				</div>
				<div class="signup-div">
				<div class="form-h3">회원 정보 삭제</div>
				<div class="signup-form">
					<form id="login-form" action="${contextPath }/userDelete.do"
						method="post">
						<button type="submit" class="btn font-22">삭제</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>