
document.getElementById('fontbutton').onclick=changeFontColor;
document.getElementById('bgbutton').onclick=changeBgColor;

function changeBgColor(){
    var bgcolor=document.getElementById('bgcolor').value;
    document.getElementById('mybox').style.backgroundColor=bgcolor; 

}

function changeFontColor(){
    var textcolor=document.getElementById('fontcolor').value;
    document.getElementById('mybox').style.color=textcolor;
}