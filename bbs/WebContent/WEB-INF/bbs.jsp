<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<style>
		body a  {
			 text-decoration:none;
			 border-bottom-color:transparent;
		}
		li {
			list-style:none;
		}
		button primary {
			align:center;
		}
	</style>
		<title>BBS</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
		<body class="is-preload">
						<!-- Table -->
							<section>
							<div align="center">
								<h3 align="center" class="button primary fit">BBS</h3>
								</div>
								<div class="table-wrapper">
									<table>
										<thead>
											<tr>
												<th width="8%" align="center">
													<a href='bbs.do?id=BBSID'>번호</a></th>
												<th width="10%" align="center">
													<a href='bbs.do?id=BBSCATEGORY'>카테고리</a></th>
												<th align="center">
													<a href='bbs.do?id=ID'>작성자</a></th>
												<th align="center">
													<a href='bbs.do?id=BBSTITLE'>제목</a></th>
												<th width="30%" align="center">
													<a href='bbs.do?id=BBSCONTENT'>내용</a></th>
												<th width="20%" align="center">
													<a href='bbs.do?id=BBSDATE'>날짜</a></th>
												<th width="10%" align="center">
													<a href='bbs.do?id=BBSHIT'>조회수</a></th>
												
											</tr>
										</thead>
										<tbody>
											<c:forEach var="bbs" items="${list}" >
												<td align="center"><a href='bbsview.do?id=${bbs.bbsId}'>${bbs.bbsId}</a></td>
												<td align="right"><c:choose>
													<c:when test="${bbs.bbsCategory=='math'}">수학</c:when>
													<c:when test="${bbs.bbsCategory=='enjoy'}">여행</c:when>
													<c:when test="${bbs.bbsCategory=='pic'}">사진</c:when>
													<c:when test="${bbs.bbsCategory=='java'}">java</c:when>
													<c:when test="${bbs.bbsCategory=='web'}">웹프로그래밍</c:when>
													<c:when test="${bbs.bbsCategory=='estate'}">부동산</c:when>
													<c:when test="${bbs.bbsCategory=='food'}">음식</c:when>
													<c:when test="${bbs.bbsCategory=='common'}">상식</c:when>

													</c:choose></td>
												<td align="right">${bbs.id}</td>
												<td align="right"><a href='bbsview.do?id=${bbs.bbsId}'>
														<b>${bbs.bbsTitle}</b> </a></td>
												<td align="right"><a href='bbsview.do?id=${bbs.bbsId}'>
														<b>${bbs.bbsContent} </b></a></td>
												<td align="right">${bbs.bbsDate}</td>
												<td align="right">${bbs.bbsHit}</td>
												</tr>
											</c:forEach>
										</tbody>
										
										<tfoot>
											<tr>
												<td colspan="2"></td>
											</tr>
										</tfoot>
									</table>
									<ul class="row" align="center">
										<li class="previous">
											<c:if test='${startPage>1}'>
												<!--  test 뒷부분에 조건을 단다  -->
												<a href='bbs.do?page=${startPage-10}'>이전</a>
											</c:if>
										</li>
										<li>
											<c:forEach begin="${startPage}" end="${endPage}" var="p">
												<a href='bbs.do?page=${p}' class="butten primary">${p}</a>
											</c:forEach>
										</li>
										<li class="next">
											<c:if test='${hasNext==true}'>
												<a href='bbs.do?page=${startPage+10}'>다음</a>
											</c:if>
										</li>
									</ul>
								</div>
								<div class="row">
								<c:if test='${sessionID!=null}'>
									<div>
										<a href='bbsupload2.do' class="button primary">WRITE</a>
									</div>
								</c:if>
									<a href='home.do'  class="button primary">HOME</a>
								</div>
								<div align="center">
						
									<c:if test='${resultBbs >= 1}'>
										<div class="w3-panel">
											<button class="button primary" width="10%">
												글쓰기 성공
											</button>
										</div>
									</c:if>
									<c:if test='${resultBbs < 1}'>
										<div class="w3-panel">
											<button class="button primary" width="10%">
											 글쓰기 실패
											</button>
										</div>
									</c:if>
									
									<c:if test='${deleteResult >= 1}'>
										<div class="w3-panel">
											<button class="button primary" width="10%">
												글삭제 성공
											</button>
										</div>
									</c:if>
									<c:if test='${deleteResult < 1}'>
										<div class="w3-panel">
											<button class="button primary" width="10%">
											 글삭제 실패
											</button>
										</div>
									</c:if>
									
										<c:if test='${updateBbsResult >= 1}'>
										<div class="w3-panel">
											<button class="button primary" width="10%">
												글수정 성공
											</button>
										</div>
									</c:if>
									<c:if test='${updateBbsResult < 1}'>
										<div class="w3-panel">
											<button class="button primary" width="10%">
											 글수정 실패
											</button>
										</div>
									</c:if>
								</div>
								
							</section>
				
			
		

	



		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
				<footer id="footer">
					<ul class="icons">
						<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
						<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
						<li><a href="#" class="icon alt fa-envelope"><span class="label">Email</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</footer>


	</body>
</html>