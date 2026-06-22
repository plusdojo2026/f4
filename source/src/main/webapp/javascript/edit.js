
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


function saveScreenshot() {

    html2canvas(document.getElementById("captureArea"))
        .then(function(screenshot) {

            const imageData = screenshot.toDataURL("image/png");

            const formData = new FormData();

            formData.append("image", imageData);

            fetch("EditServlet", {
                method: "POST",
                body: formData
            });

        });
}

/*
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
