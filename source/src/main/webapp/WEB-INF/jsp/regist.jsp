<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
</head>
<body>
<form method="POST" action="/f4/ResistServlet">
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
		<input type="submit" name="resist">
		<input type="reset" name="reset">
	</div>
</form>
</body>
</html>