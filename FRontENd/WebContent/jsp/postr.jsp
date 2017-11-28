<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.diy.vo.BoardVO"%>
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
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${contextPath }/js/post.js"></script>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<script>
		document.getElementById('opt').setAttribute('value','recipe');
		document.getElementById('searchbar').setAttribute('placeholder','recipe search...');
	</script>
	<div class="container">
		<div class="body_wrap">
			<div id="quest_bar">
				<div class="sub_header">
					<h1 style="font-size: 1.5rem;">${post.getBdTitle()}</h1>
				</div>
				<table class="content-form">
					<tbody>
						<tr>
							<td>
								<div class="content">${post.getBdContent() }</div>
							</td>
						</tr>
						<tr class="dex">
							<td class="post-nickname">
								<div>작성자 : ${post.getUserID() }</div>
							</td>
							<td class="post-date">
								<div>${post.getBdDate() }</div>
							</td>
							<c:if test="${post.getUserID().equals(user.getId()) }">
								<td class="post-edit">
								<a href="deletePost.do?rorq=recipe&id=${post.getBdID()}">delete</a>
								</td>
							</c:if>
						</tr>
						<tr>
							<td><div style="margin: 10px 0 10px 0;"></div></td>
						</tr>
					</tbody>
				</table>
				<br> <a class="in" onclick="toggler()" href="#">comments...</a>
				<div class="comment-side out">
					Comments
					<c:if test="${!empty user}">
						<div>
							<form class="m-comment" action="comment.do">
								<input type="text" name="content"
									placeholder="Add your comment... " /> <input type="hidden"
									name="id" value="${post.getBdID()}"> <input type="hidden"
									name="rorq" value="recipe">
								<!--  <input type="submit" value="" /> -->
								<button type="submit"></button>
							</form>
						</div>
					</c:if>
					<div class="comments">
						<c:forEach var="item" items="${ clist }" varStatus="status">
							<div class="comment">
								<div style="display: block;" class="comment-body">
									<span class="comment-copy">${item.getContent() } </span>
									–&nbsp;<a href="#"
										title="157,120 reputation" class="comment-user">${item.getUserid() }
									</a> <span class="comment-date" dir="ltr"><a
										class="comment-link" href="#"><span
											title="2013-12-22 21:42:53Z" class="relativetime-clean">${item.getDate() }
										</span></a></span>
								</div>
							</div>
						</c:forEach>
					</div>
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
			myModal.find('.modal-title').text('Post Error');
			myModal.find('.modal-body').text('${error}');
			myModal.modal();
		</script>
	</c:if>
</body>
</html>