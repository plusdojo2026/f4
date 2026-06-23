<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>検索結果！</h1>


<c:forEach var="e" items="${recordList}" >
	<form method="POST" action="/f4/SearchServlet">
	ユーザーID<input type="text" name="company" value="${e.userId}"><br>
	日付<input type="date" name="department" value="${e.createDate}"><br>

	</form>
</c:forEach>

<p><a href="/f4/SearchServlet">検索画面に戻る</a></p>

</body>
</html>