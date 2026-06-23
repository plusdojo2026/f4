<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<div id="captureArea">
	<img src="images_back/main.png" alt="">
	<c:forEach var="character" items="${characterList }">
	<img 
		id="characterImage"
		src="${character.characterMainImg}" 
		alt="キャラ画像" 
		width="500" height="300"
	>
    </div>	
	</c:forEach>
	
    <canvas
        id="canvas"
        width="1250"
        height="600"
        style="border:1px solid #ccc;">
    </canvas>
</div>

<script src="https://cdn.jsdelivr.net/npm/signature_pad@5.0.4/dist/signature_pad.umd.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/html2canvas@1.4.1/dist/html2canvas.min.js"></script>
<!-- <script src="javascript/edit.js"></script> -->

<!--
<form id="editForm" method="POST" action="/f4/EditServlet">
    <input type="hidden" id="imageData" name="imageData">

    <input type="button" value="保存" onclick="saveScreenshot()">
</form>
-->
<button onclick="saveScreenshot()">保存</button>

<script>

const canvas = document.getElementById("canvas");

/* canvasに落書き機能を持たせる */
const signaturePad = new SignaturePad(canvas);


let isRed = false;
/* 色の切り替え */
function toggleColor() {
    isRed = !isRed;

    if (isRed) {
        signaturePad.penColor = "red";
    } else {
        signaturePad.penColor = "black";
    }
}

/* スクリーンショット保存機能 */
function saveScreenshot() {
	/* captureAreaを保存 */
    html2canvas(document.getElementById("captureArea"))
        .then(function(screenshot) {
        
        	screenshot.toBlob(function(blob) {

            const formData = new FormData();

            formData.append(
                "image",
                blob,
                "screenshot.png"
            );

            fetch("/f4/EditServlet", {method: "POST", body: formData});

            });

        });
}
</script>

</body>
</html>