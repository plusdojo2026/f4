/**
 * 
 */
 
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
const canvas = await html2canvas(
    document.getElementById("captureArea")
);
*/

