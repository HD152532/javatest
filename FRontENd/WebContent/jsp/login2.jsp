<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="openapi.capcha"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<link href="${contextPath }/css/style.css" rel='stylesheet'
	type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="shortcut icon" type="image/x-icon" href="images/fav-icon.png" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!----//webfonts---->
<!-- Global CSS for the page and tiles -->
<link rel="stylesheet" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<script>
		document.getElementById('opt').setAttribute('value', 'question');
		document.getElementById('searchbar').setAttribute('placeholder','question search...');
	</script>
	<div class="container">
		<div class="body_wrap">
			<div class="signup-div">
				<div class="form-h3">Welcome to DIY RECIPE. Hurry to Login!</div>
				<div class="signup-form">
					<form id="login-form" action="${contextPath }/login.do"
						method="post">
						<div class="form-group">
							<label for="exampleInputID1">ID</label> <input type="text"
								class="form-control" name="id" id="exampleInputID1"
								aria-describedby="idHelp" placeholder="Enter ID">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" name="pwd"
								id="exampleInputPassword1" placeholder="Password">
						</div>
						<div class="g-recaptcha" data-sitekey="6LfviDoUAAAAANcXi-11RSt2JY_dwydOdLjMMbxn"></div>
<%-- 						<img src="${contextPath}/capcha/${tempname}.jpg" width="200px" --%>
<!-- 							height="50px"> <input type="text" class="form-control" -->
<!-- 							name="id" placeholder="insert key..."> <input -->
<!-- 							type="hidden" name="path" -->
<%-- 							value="<%=request.getAttribute("path")%>"> --%>
						<button type="submit" class="btn font-22">login</button>
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


	<c:if test="${error != null }">
		<script>
			var myModal = $('#myModal');
			myModal.find('.modal-title').text('Login Error');
			myModal.find('.modal-body').text('${error}');
			myModal.modal();
		</script>
	</c:if>
</body>
</html>