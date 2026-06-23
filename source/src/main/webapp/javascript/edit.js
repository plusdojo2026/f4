
const canvas = document.getElementById("canvas");

const signaturePad = new SignaturePad(canvas);

/* 色の切り替え */
let isRed = false;

function toggleColor() {
    isRed = !isRed;

    if (isRed) {
        signaturePad.penColor = "red";
    } else {
        signaturePad.penColor = "black";
    }
}

/*
async function saveScreenshot() {

    const screenshot = await html2canvas(document.getElementById("captureArea"));

    const imageData = screenshot.toDataURL("image/png");

    document.getElementById("imageData").value = imageData;

    document.getElementById("editForm").submit();
}
*/


/*eclipse
function saveScreenshot() {

    html2canvas(document.getElementById("captureArea"))
        .then(function(screenshot) {
        
        	screenshot.toBlob(function(blob) {

            const formData = new FormData();

            formData.append(
                "image",
                blob,
                "screenshot.png"
            );

            fetch("/f4/EditServlet", {
                method: "POST",
                body: formData
            });

            });

        });
}
*/


/* base64データベース保存
function saveScreenshot() {

    html2canvas(document.getElementById("captureArea"))
        .then(function(screenshot) {

            const imageData = screenshot.toDataURL("image/png");

            const formData = new FormData();

            formData.append("image", imageData);

            fetch("/f4/EditServlet", {
                method: "POST",
                body: formData
            });

        });
}
*/


/* 旧
   function saveScreenshot() {  

    const screenshot = html2canvas(document.getElementById("captureArea")); 

    const imageData = screenshot.toDataURL("image/png");
    
    const formData = new FormData();
    
    formData.append("image", imageData);

	fetch("EditServlet", 
		{
    	method: "POST",
    	body: formData
    	}
	);
}
*/
