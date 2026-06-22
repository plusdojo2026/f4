/**
 * 
 */
 document.addEventListener("DOMContentLoaded", function () {

    const characterImage = document.getElementById("characterImage");
    const imageElements = document.querySelectorAll("#imageList span");

    if (!characterImage || imageElements.length === 0) {
        return;
    }

    const imageList = Array.from(imageElements).map(function (element) {
        return element.dataset.img;
    });

    let currentIndex = 0;

    characterImage.addEventListener("click", function () {
        currentIndex++;

        if (currentIndex >= imageList.length) {
            currentIndex = 0;
        }

        characterImage.src = imageList[currentIndex];
    });

});