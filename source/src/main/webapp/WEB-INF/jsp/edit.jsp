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

<div class="wrapper">
	<!-- スクリーンショットエリア -->
	<div id="captureArea">
	
		<!-- 背景画像 -->
		<div id="background">
			<img src="images_home/home1980.png" alt="">
		</div>
		
		<!-- キャラクター画像 -->
		<c:forEach var="character" items="${characterList }">
			<img 
			id="characterImage"
			src="${pageContext.request.contextPath}/${character.characterMainImg}" 
			alt="キャラ画像" 
			width="500" height="300"
			>
			<!-- 画像切り替え用の画像リスト -->
	    	<div id="imageList" style="display: none;">
	        <!-- 最初のメイン画像もリストに入れる -->
	        <span data-img="${pageContext.request.contextPath}/${character.characterMainImg}"></span>
	
	        <!-- 差分画像リスト -->
	        <c:forEach var="sub" items="${characterSubList}">
	            <span data-img="${pageContext.request.contextPath}/${sub.characterSubImg}"></span>
	        </c:forEach>
	    	</div>
		</c:forEach>
		
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
	
	<div class="edit-bottom">
		<!-- 戻るボタン -->
		<div id="return">
			<!-- <a href="DailyCharacterServlet">戻る</a> -->
			<a href="DailyCharacterServlet"><img src="images_back/RETURN.png" alt="戻る"></a>
		</div>
		
		<!-- 色切り替えボタン -->
		<div id="pen">
			<!-- <button onclick="toggleColor()">色切替</button> -->
			<img src="images_back/PEN.png" alt="色切替" onclick="toggleColor()">
		</div>
		
		<!-- 保存ボタン -->
		<div id="save">
			<!-- <button onclick="saveScreenshot()">保存</button> -->
			<img src="images_back/CAMRA.png" alt="色切替" onclick="saveScreenshot()">
		</div>
	
</div>

</div>



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
    const element = document.getElementById("captureArea");
	html2canvas(element,  {scale: 1920 / element.offsetWidth})

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