
<!-- BLOCK ERROR SCRIPT

function blockError(){return true;}
window.onerror = blockError;

// -->




<!-- MOUSEOVER SCRIPT


if (document.images) {


nexton = new Image(120, 55);
nexton.src = "picts/nexton.gif"

nextoff = new Image(120, 55);
nextoff.src = "picts/nextoff.gif"


}

function img_act(imgName) {
if (document.images) {
imgOn = eval(imgName + "on.src");
document [imgName].src = imgOn;
}
}

function img_inact(imgName) {
if (document.images) {
imgOff = eval(imgName + "off.src");
document [imgName].src = imgOff;
}
}


// -->