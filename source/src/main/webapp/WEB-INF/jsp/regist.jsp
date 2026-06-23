<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
<link rel="stylesheet" href="css/regist.css">
</head>
<body>
<form method="POST" action="/f4/RegistServlet">
	<div>
		<div>
	    	<label>ユーザーID<br>
			<input type="text" name="userId">
			</label>
		</div>
		<div>
			<label>パスワード<br>
			<input type="password" name="password">
			</label>
		</div>
	</div>
	<div>
		<input type="submit" value="登録">
		<input type="reset" value="リセット">
	</div>
</form>
</body>
</html>