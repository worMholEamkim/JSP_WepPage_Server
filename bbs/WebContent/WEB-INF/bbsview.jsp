 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>게시판 볼거야 야무지게</title>
<meta charset="utf-8">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
<style>
 
	box {
		display: inline;
		transition: border-color 0.2s ease-in-out;
	    background: transparent;
	    border-radius: 4px;
	    border: solid 1px rgba(255, 255, 255, 0.3);
	    color: inherit;
	    text-decoration: none;
	    

	}
	
	a {
		color:white;
		text-decoration:none;
		border-bottom-color:transparent;
		
	}
	
	
</style>

</head>
<body class="is-preload">
	<%
		String sessionID = null;
		if (session.getAttribute("sessionID") != null) {
			sessionID = (String) session.getAttribute("sessionID");
		}
	%>
	<div class="wrapper style1">


							<section>
								
								<form>
								<botton class="button primary fit"><a href="bbs.do">게시판</a></botton>
									<div> 
									
										
										<div class="box">
											조회수 : ${bbsview.bbsHit}
										</div>
										<div class="box">
											카테고리 : ${bbsview.bbsCategory}
										</div>
										<div class="box">
											작성자 : ${bbsview.id}
										</div>
										<div class="box">
											날짜 : ${bbsview.bbsDate}
										</div>
						
										<div class="box">
											제목 : ${bbsview.bbsTitle}
										</div>
										
										<div class="box">
											<p style=" font-size: 20px; line-height:2; padding: 50px 50px;">
										${bbsview.bbsContent}</p>
										</div>
								
										<div class="row">
											<c:forEach var="item" items="${files}" >
												<a href="bbsFile.do?id=${item.fileId}" target="_blank">${item.orgn_File_Nm}
												첨부된 파일</a>
											</c:forEach>
										</div>
										
									</div>

									<div>
										<c:choose>
											<c:when test="${bbsview.id ==sessionID}">
												<button class="button primary">
													<a href="bbsdelete.do?id=${bbsview.bbsId}">삭제</a>
												</button>
												<button class="button primary">
													<a href="bbsupdate.do?id=${bbsview.bbsId}">수정</a>
												</button>
									
											</c:when>
											<c:otherwise>
												<button class="button primary">
													삭제x</button>
												<button class="button primary">
													수정x</button>
											</c:otherwise>
										</c:choose>

								</form>
	<td>
							<button class="button primary">
								<a href='bbsupload2.do'>글쓰기</a>
							</button>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td>
						</td>

						<td colspan="2">
							<button class="button primary">
								<a href='bbs.do'>게시판</a>
							</button>
						</td>

						<td>
						</td>
					</tr>

					<tr>
					
							<button class="button primary">
								<a href='home.do'>처음으로</a>
							</button>
						
					</tr>
							</section>
							

		</div>
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
