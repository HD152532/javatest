<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.diy.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!---start-header---->
<div class="header">
	<div class="nav_wrap">
		<div class="logo">
			<a href="${contextPath }/view.do?rorq=question">DIY RECIPE</a>
		</div>
		<div class="menus">
			<ul style="margin-bottom: 0;">
				<li class="menu"><a href="${contextPath }/view.do?rorq=question" class="menu-font">Question</a></li>
				<li class="menu"><a href="${contextPath }/view.do?rorq=recipe" class="menu-font">ReCIPE</a></li>
			</ul>
		</div>
		<div class="top-searchbar" style="font-size: small;">
			<form action="view.do" id="search">
				<input type="text" id="searchbar" name="searchcontent" placeholder="Search... " /> <input type="submit" id="submit"
					value="" />
				<input type="hidden" id="opt" name="rorq" value="">
			</form>
		</div>
		<c:if test="${empty user}">
			<div class="menus">
				<ul style="margin-bottom: 0;">
					<li class="menu"><a href="${contextPath }/jsp/signup.jsp"
						class="menu-font">Sign Up</a></li>
					<li class="menu"><a href="${contextPath }/jsp/login.jsp"
						class="menu-font">Sign In</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${!empty user}">
			<div class="menus">
				<ul style="margin-bottom: 0; display:flex; align-items:center;font-size:10px;">
					<li class="menu"><a class="userinfo" id="userinfo" href="${contextPath}/jsp/userInfo.jsp"><img src="${contextPath}/images/house.png" width="20px" height="20px"></a></li>
					<li class="menu"><a href="${contextPath }/logout.do" method="post"
						class="menu-font">Logout</a></li>
				</ul>
			</div>
		</c:if>
		<div class="clear"></div>
	</div>
</div>