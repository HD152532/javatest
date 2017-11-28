<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.diy.vo.UserVO"%>
<%@ page import="org.diy.service.BoardService"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="body_wrap">
		<div id="main_bar">
			<!-- 			<div id="search-cnt"> -->
			<!-- 				<p>results: recipes</p> -->
			<!-- 			</div> -->
			<div class="sub_header">
				<h1 style="font-size: 1.5rem;">
					Recipes :
					<c:if test="${empty searchcontent}">
					ALL
					</c:if>
					${searchcontent}
				</h1>

				<div id="tabs">
					<a
						href="view.do?align=n&rorq=recipe&searchcontent=${searchcontent}"
						class="tab">oldest(default)</a><a
						href="view.do?align=l&rorq=recipe&searchcontent=${searchcontent}"
						class="tab">lately</a> <a
						href="view.do?align=v&rorq=recipe&searchcontent=${searchcontent}"
						class="tab">mostViewed</a><a
						href="view.do?align=c&rorq=recipe&searchcontent=${searchcontent}"
						class="tab">mostAnswered</a>
				</div>
			</div>
			<div class="results">
				<c:choose>
					<c:when test="${empty posts}">
						<c:if test="${empty searchcontent}">
							<div class="result">아직 등록된 글이 없습니다.</div>
						</c:if>
						<c:if test="${!empty searchcontent}">
							<div class="result">검색결과 0건입니다.</div>
						</c:if>
					</c:when>
					<c:when test="${!empty posts}">
						<c:if test="${!empty searchcontent}">
							<div class="result">검색결과 ${posts.size()}건입니다.</div>
						</c:if>
						<c:if test="${empty searchcontent}">
							<div class="result">이때까지의 총 RECIPE ${posts.size()}건</div>
						</c:if>
						<c:forEach var="item" items="${ posts }" varStatus="status">
							<div class="result">
								<div class="statscontainer">
									<div class="statsarrow"></div>
									<div class="stats">
										<div class="vote" id="answer">
											<div class="votes ">
												<span class="vote-count-post "><strong>${item.getCnt() }</strong></span>
												<div class="viewcount">comments</div>
											</div>
										</div>
									</div>
									<div class="view">
										<div class="views">
											<span class="view-count-post"><strong>${item.getBdViews()}</strong></span>
											<div class="viewcount">views</div>
										</div>
									</div>
								</div>
								<div class="summary">
									<h3>
										<a
											href="${contextPath}/post.do?id=${item.getBdID()}&rorq=recipe">${item.getBdTitle()}</a>
									</h3>
									<div class="excerpt">${item.getBdContent()}</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div id="sub_bar">
			<div class="module" id="question_count">
				<div class="-details">
					<div class="summarycount_all">Write your</div>
					<p>recipes</p>
				</div>
				<div class="aside-cta" role="navigation"
					aria-label="ask new question">
					<a class="btn font-16"
						href="${contextPath}/session.do?path=jsp/writer.jsp">Post
						Recipe</a>
				</div>
			</div>
		</div>
	</div>
</div>