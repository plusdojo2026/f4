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

<!-- 色切り替えボタン -->
<div>
	<button onclick="toggleColor()">色切替</button>
</div>

<!-- スクリーンショットエリア -->
<div id="captureArea">

	<!-- 背景画像 -->
	<div id="background">
		<!-- <img src="images_home/home1980.png" alt=""> -->
		<img src="images_screenshot/2026-06-24.png" alt="">
	</div>
	
	<!-- キャラクター画像 
	<c:forEach var="character" items="${characterList }">
	<img 
		id="characterImage"
		src="${character.characterMainImg}" 
		alt="キャラ画像" 
		width="500" height="300"
	>	
	</c:forEach>
	-->
	
	<div id="characterImage">
		<img src="images/maamaa.png" alt="">
	</div>
	
	<!-- キャンバス -->
    <canvas
        id="canvas"
        style="border:1px solid #ccc;">
    </canvas>
</div>

<!-- キャンバスに描画できるライブラリ -->
<script src="https://cdn.jsdelivr.net/npm/signature_pad@5.0.4/dist/signature_pad.umd.min.js"></script>

<!-- スクリーンショットのライブラリ -->
<script src="https://cdn.jsdelivr.net/npm/html2canvas@1.4.1/dist/html2canvas.min.js"></script>
<!-- <script src="javascript/edit.js"></script> -->

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
    html2canvas(document.getElementById("captureArea"),{width: 1920,height: 1080})
        

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

//キャンバスの線の位置を合わせる
function resizeCanvas() {
    const ratio = Math.max(window.devicePixelRatio || 1, 1);

    canvas.width = canvas.offsetWidth * ratio;
    canvas.height = canvas.offsetHeight * ratio;

    canvas.getContext("2d").scale(ratio, ratio);

    signaturePad.clear();
}

window.addEventListener("resize", resizeCanvas);
resizeCanvas();
</script>

</body>
</html>