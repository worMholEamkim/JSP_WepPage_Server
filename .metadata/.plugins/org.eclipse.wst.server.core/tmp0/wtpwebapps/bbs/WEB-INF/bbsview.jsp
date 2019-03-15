<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body style="background-color:#999999;">
	<%
		String sessionID = null;
		if (session.getAttribute("sessionID") != null) {
			sessionID = (String) session.getAttribute("sessionID");
		}
	%>
	<div class="container">

		<div class="w3-panel">
			<table class="table table-hover" border=0px>
				<thead>
					<tr>
						<th colspan="4">게시판</th>
					</tr>
					<tr>
						<td width=25%>조회수: ${bbsview.bbsHit}</td>
						<td width=25%>카테고리	: ${bbsview.bbsCategory}</td>
						<td width=25%>작성자: ${bbsview.id}</td>
						<td width=25%>날짜: ${bbsview.bbsDate}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="4">
							<button class="w3-button w3-block w3-button w3-black">제목
								: ${bbsview.bbsTitle}</button>
						</td>
					</tr>

					<tr>
						<td colspan="4">
							<div class="w3-panel">
								<p style="background-color: black; color: white; font-size: 20px; line-height:2; padding: 50px 50px;">
									${bbsview.bbsContent}</p>
							</div>
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td colspan="4">
							<div class="w3-panel">
								<c:forEach var="item" items="${files}" >
									<a href="bbsFile.do?id=${item.fileId}" target="_blank">${item.orgn_File_Nm}
									</a>
								</c:forEach>
							</div>
						</td>
					</tr>

					<tr>
						<td></td>
						<c:choose>
							<c:when test="${bbsview.id ==sessionID}">
								<td>
									<button class="w3-button w3-block w3-button w3-red">

										<a href="bbsdelete.do?id=${bbsview.bbsId}">삭제</a>

									</button>
								</td>
								<td>
									<button class="w3-button w3-block w3-button w3-black">

										<a href="bbsupdate.do?id=${bbsview.bbsId}">수정</a>

									</button>
								</td>
							</c:when>
							<c:otherwise>
								<td>
									<button class="w3-button w3-block w3-button w3-red">
										삭제x</button>
								</td>
								<td>
									<button class="w3-button w3-block w3-button w3-black">
										수정x</button>
								</td>
							</c:otherwise>
						</c:choose>
						<td>
							<button class="w3-button w3-block w3-button w3-indigo">
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
							<button class="w3-button w3-block w3-button w3-indigo">
								<a href='bbs.do'>게시판</a>
							</button>
						</td>

						<td>
						</td>
					</tr>

					<tr>
						<td colspan="4">
							<button class="w3-button w3-block w3-button w3-black">
								<a href='home.do'>처음으로</a>
							</button>
						</td>
					</tr>
					<tr>
						<td colspan="2"></td>
						<td colspan="2" align="right">
<!-- 							<div style="display: inline-block; width: 100%;"> -->
<!-- 								<form> -->
<!-- 									<input type="text" name="commentContent" -->
<!-- 										style="width: 90%; padding: 12px 20px; margin: 8px 0; box-sizing: border-box; border: 2px solid glay; outline: none;"> -->

<!-- 									<button type="submit" -->
<!-- 										class="w3-button w3-block w3-button w3-red" -->
<!-- 										style="width: 40%;"> -->
<%-- 										<a href='bbscomment.do?id=${bbsview.bbsId}'>댓글달기</a> --%>
<!-- 									</button> -->
<!-- 								</form> -->
<!-- 							</div> -->
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
</html>



