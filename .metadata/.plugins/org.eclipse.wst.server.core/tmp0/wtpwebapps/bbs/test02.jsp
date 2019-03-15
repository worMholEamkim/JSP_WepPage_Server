<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = "JSP, Java, Oracle, JQuery";
	pageContext.setAttribute("str", str);
	%>
	<c:forTokens var = "item" items="${str}" delims=",">
		${item} <br />
	</c:forTokens>
	
	<c:out value="<h1>HI</h1>" />
	<c:out value="<h1>HI</h1>" escapeXml="false"/>
	<c:out value="${result}" default="데이터 오류" />
	
</body>
</html>