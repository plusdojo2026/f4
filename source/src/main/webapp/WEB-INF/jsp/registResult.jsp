<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録結果画面</title>
</head>
<body>
<h1><c:out value="${result.title}" /></h1>
<hr>
<p><c:out value="${result.message}" /></p>
<a href="${result.backTo}">新規登録画面へ戻る</a>
</body>
</html>