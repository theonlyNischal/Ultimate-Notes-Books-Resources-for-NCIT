var currentTopImage = "img4";

function moveTop(newTopImage) {
  var currentImage = document.getElementById(currentTopImage).style;
  var newImage = document.getElementById(newTopImage).style;

  currentImage.zIndex = "0";
  newImage.zIndex = "15";

  currentTopImage=newTopImage;
}
