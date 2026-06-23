<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<h1>ログイン画面</h1>

<!-- 新規登録ボタン -->
<div class="regist-container">
    <p><a href="/f4/RegistServlet">新規登録</a></p>
</div>


<form method="POST" action="/f4/LoginServlet">
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
	<div class="button-group">
    <input type="submit" name="login" value="ログイン">
    <input type="reset" name="reset" value="リセット">
</div>
</form>
</body>
</html>