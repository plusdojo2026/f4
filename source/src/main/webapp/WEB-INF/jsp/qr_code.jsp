<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！｜QR画面</title>
<link rel="stylesheet" href="css/qr_code.css">
</head>
<body>

<h1>QR画面</h1>

<!-- 戻るボタン -->
<div id="return">
	<!-- <a href="DailyCharacterServlet">戻る</a> -->
	<a href="DailyCharacterServlet"><img src="images_back/RETURN.png" alt="戻る"></a>
</div>
<img src="<%= request.getContextPath() %>/QrImageServlet" alt="QRコードの表示" id="qr">
</body>
</html>