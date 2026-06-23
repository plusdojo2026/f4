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


<form id="login_form" method="POST" action="/f4/LoginServlet">
	<div>
		<div>
	    	<label>ユーザーID<br>
			<input type="text" name="userId" id="userId">
			</label>
		</div>
		<div>
			<label>パスワード<br>
			<input type="password" name="password" id="password">
			</label>
		</div>
	</div>
	<div class="button-group">
    <input type="submit" name="login" value="ログイン">
    <input type="reset" name="reset" value="リセット">
</div>
</form>
<script>
'use strict' // 正しいスペルに修正

document.getElementById('login_form').onsubmit = function(event){
    // HTMLのname属性ではなく、id属性で取得します
    let idInput = document.getElementById('userId');
    let pwInput = document.getElementById('password');
    
    let id = idInput.value;
    let pw = pwInput.value;

    if(id === '' && pw === ''){
        window.alert('ユーザーID、パスワードを入力してください。');
        idInput.style.backgroundColor = 'pink';
        pwInput.style.backgroundColor = 'pink';
        event.preventDefault();
    }
    else if(id === ''){
        window.alert('ユーザーIDを入力してください。');
        idInput.style.backgroundColor = 'pink';
        // パスワード側の色をリセット
        pwInput.style.backgroundColor = 'white'; 
        event.preventDefault();
    }
    else if(pw === ''){
        window.alert('パスワードを入力してください。');
        pwInput.style.backgroundColor = 'pink';
        // ID側の色をリセット
        idInput.style.backgroundColor = 'white';
        event.preventDefault();
    }
}
</script>
</body>
</html>