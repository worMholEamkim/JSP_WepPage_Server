<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList list = new ArrayList();
		list.add("ABC");
		list.add("ZYX");
		request.setAttribute("list", list);
	%>
	
	<c:forEach var = "item" items="${list}">
		${item} <br/>
	</c:forEach>
</body>
</html>