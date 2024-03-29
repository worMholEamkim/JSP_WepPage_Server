<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>게시판 업로드데스</title>
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
			<button class="button primary fit"><a href="bbs.do">게 시 판</a></button>
		</div>
		<div align="center">
			<form method="post" action="bbsupdate.do">
				<table border=0px>
					<tr>
						<td><h5>글 번호</h5></td>
						<td  class="box" colspan="2"><input name="bbsId" type="text" value="${bbsUpdate.bbsId}"  readonly
							style="width: 90%; padding: 12px 20px; margin: 10px 0px; box-sizing: border-box; border-radius: 4px;
	    border: solid 1px rgba(255, 255, 255, 0.3);">
						</td>
					</tr>
					<tr>
						<td><h5>카테고리</h5></td>
						<td colspan="2" class="box">
						<select name="category"
							style="width: 90%; padding: 12px 20px; font-size: 18px; margin: 10px 0px; box-sizing: border-box; border-radius: 4px;
	    border: solid 1px rgba(255, 255, 255, 0.3);">
								<c:if test="${bbsUpdate.bbsCategory == 'math'}">
									<option value="math" selected>수학</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'math'}">
									<option value="math">수학</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'enjoy'}">
									<option value="enjoy" selected>여행</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'enjoy'}">
									<option value="enjoy">여행</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'pic'}">
									<option value="pic" selected>사진</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'pic'}">
									<option value="pic">사진</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'java'}">
									<option value="java" selected>java</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'java'}">
									<option value="java">java</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'web'}">
									<option value="web" selected>웹프로그래밍</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'web'}">
									<option value="web">웹프로그래밍</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'estate'}">
									<option value="estate" selected>부동산</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'estate'}">
									<option value="estate">부동산</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'food'}">
									<option value="food" selected>음식</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'food'}">
									<option value="food">음식</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory == 'common'}">
									<option value="common" selected>상식</option>
								</c:if>
								<c:if test="${bbsUpdate.bbsCategory != 'common'}">
									<option value="common">상식</option>
								</c:if>
						</select>
						</td> 

					</tr>
					<tr>
						<td><h5>제 목</h5></td>
						<td colspan="2"  class="box"><input name="title" type="text" value="${bbsUpdate.bbsTitle}"
							style="width: 90%; padding: 12px 20px; margin: 10px 0px; box-sizing: border-box; border-radius: 4px;
	    border: solid 1px rgba(255, 255, 255, 0.3);">
						</td>
					<tr>
					<tr>
						<td><h5>내 용</h5></td>
						<td colspan="2" class="box"><textarea name="content" rows="20" cols="80"
								style="width: 90%; padding: 12px 20px; margin: 10px 0px; box-sizing: border-box; border-radius: 4px;
	    border: solid 1px rgba(255, 255, 255, 0.3);;">
								${bbsUpdate.bbsContent}</textarea>
						</td>
					</tr>
					
					<tr>
						<td colspan="5"><br>
						</td>
					<tr>

						<script type="text/javascript">
							var uf = "";
							function file_add(size, ext) {
								var filecountTemp = parseInt(document
										.getElementById("file_cnt").value);
								var parents = document
										.getElementById("file_add_form");
								var br = document.createElement("br");
								br.setAttribute("id", "br" + (filecountTemp + 1));
								parents.appendChild(br);
								if (filecountTemp == 30) {
									alert("파일업로드는 최대 30개까지 가능합니다"); //< --- 이 부분 지우면 무한대로 추가됨.
									return;
								} else {
									var obj = document.createElement("input");
									obj.setAttribute("type", "file");
									obj.setAttribute("size", size);
									obj.setAttribute("name", "bbs_file"
											+ (filecountTemp + 1));
									obj.setAttribute("id", "file"
											+ (filecountTemp + 1));
									parents.appendChild(obj);
								}
								document.getElementById("file_cnt").value = filecountTemp + 1;
							}
							function file_delete() {
								var filecountTemp = parseInt(document
										.getElementById("file_cnt").value);
								var parents = document
										.getElementById("file_add_form");
								var obj = document.getElementById('file'
										+ filecountTemp);
								var br = document.getElementById('br'
										+ filecountTemp);
								parents.removeChild(obj);

								document.getElementById("file_cnt").value = filecountTemp - 1;
							}
						</script>

						<td colspan="2"></td>

						<td colspan="2">
						<div style="width: 50%;">
						<input type="hidden" id="file_cnt"
							name="file_cnt" value="1" style=""> 
							<button class="button primary">
								<a href="javascript:file_add(50, 'class=input_write');"><b>첨부파일추가</b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</button>
							<button class="button primary">
								<a href="javascript:file_delete();"><b>첨부파일삭제</b></a>
							</button>
						</div>
						</td>
					</tr>
						<td></td>
						
						<td colspan="3"><button type="submit"
								class="button primary"
								>보내기</button>
								<button class="button primary">
									<a href='bbs.do'>게시판</a>
								</button>
					
								<button class="button primary">
									<a href='home.do'>처음으로</a>
								</button>
						</td>
					</tr>
				</table>
			</form>
		</div>

			
	</div>
</body>
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
</html>


