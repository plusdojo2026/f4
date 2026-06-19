<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>落書き｜ぱぱっとコミュ！</title>
<link rel="stylesheet" href="css/edit.css">
</head>
<body>

<h1>落書き画面</h1>

<div>
	<button onclick="toggleColor()">色切替</button>
</div>

<div>
    <canvas
        id="canvas"
        width="1250"
        height="600"
        style="border:1px solid #ccc;">
    </canvas>
</div>

<script src="https://cdn.jsdelivr.net/npm/signature_pad@5.0.4/dist/signature_pad.umd.min.js"></script>
<script src="javascript/edit.js"></script>

<form method="POST" action="/f4/EditServlet">

	<input type="submit" name="screenshot" value="保存">

</form>

</body>
</html>