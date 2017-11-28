<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.diy.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${contextPath }/css/style.css" rel='stylesheet'
	type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="images/fav-icon.png" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>userinfo</title>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<script>
		document.getElementById('opt').setAttribute('value', 'question');
		document.getElementById('searchbar').setAttribute('placeholder','question search...');
		document.getElementById('userinfo').setAttribute('href','#');
	</script>
	<div class="container">
		<div class="body_wrap">
			<div id="quest_bar">
				<div class="sub_header">
					<h1 style="font-size: 1.5rem;">Id: ${user.getId()}</h1>
				</div>
				<div class="sub_header">
					<h1 style="font-size: 1.5rem;">Name : ${user.getName() }</h1>
				</div>
				<div class="sub_header">
					<h1 style="font-size: 1.5rem;">NickName : ${user.getNickname() }</h1>
				</div>
				<form class="infochange" action="${contextPath }/jsp/infochange.jsp" method="post">
					<input type="password" name="pwd"
						placeholder="Insert your password" required/>
					<!--  <input type="submit" value="" /> -->
					<button type="submit" class="btn">회원정보 변경/삭제</button>
				</form>
				<iframe width="560" height="315" src="https://www.youtube.com/embed/dlDYqE32_AA" frameborder="0" allowfullscreen></iframe>
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
			myModal.find('.modal-title').text('Error');
			myModal.find('.modal-body').text('${error}');
			myModal.modal();
		</script>
	</c:if>
</body>
</html>