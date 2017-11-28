<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.diy.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">
<head>
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
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<script>
		document.getElementById('opt').setAttribute('value','question');
		document.getElementById('searchbar').setAttribute('placeholder','question search...');
	</script>
	<div class="container">
		<div class="body_wrap">
			<div id="quest_bar">
				<form action="${contextPath}/write.do">
					<input type="text" id="title" name="bdTitle" class="form-control" placeholder="title">
					<textarea id="content" name="bdContent" class="form-control" placeholder="content"></textarea>
					<input type="hidden" name="rorq" value="question">
					<button type="submit" class="btn">글올리기</button>
				</form>
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
			myModal.find('.modal-title').text('글 작성 에러');
			myModal.find('.modal-body').text('${error}');
			myModal.modal();
		</script>
	</c:if>
</body>
</html>