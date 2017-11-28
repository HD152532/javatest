<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath }/css/style.css" rel='stylesheet'
	type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="images/fav-icon.png" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!----//webfonts---->
<!-- Global CSS for the page and tiles -->
<link rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="body_wrap">
			<div class="signup-div">
				<div class="form-h3">Welcome to DIY RECIPE. Create your
					account!</div>
				<div class="signup-form">
					<form id="login-form" action="${contextPath }/signup.do"
						method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">ID</label> <input type="text"
								class="form-control" id="exampleInputEmail1" name="id"
								aria-describedby="emailHelp" placeholder="Enter ID">
						</div>
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
						<button type="submit" class="btn font-22">Signup</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="modal.jsp"%>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	<%-- 회원가입이 실패한 경우 처리 추가 --%>
	<c:if test="${error != null }">
		<script>
			var myModal = $('#myModal');
			myModal.find('.modal-title').text('Sign Up Error');
			myModal.find('.modal-body').text('${error}');
			myModal.modal();
		</script>
	</c:if>
</body>
</html>