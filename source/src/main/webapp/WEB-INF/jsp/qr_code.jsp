<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>QR画面</h1>

<p><a href="/f4/HomeServlet">戻る</a></p>
<img src="<%= request.getContextPath() %>/QrImageServlet" alt="QRコードの表示">
</body>
</html>