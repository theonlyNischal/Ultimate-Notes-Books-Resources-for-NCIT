

function changepos(){
    var newleft=document.getElementById('leftcoord').value;
    var newtop=document.getElementById('topcoord').value;

    var obj=document.getElementById('mybox');

    obj.style.left=newleft+"px";
    obj.style.top=newtop+"px";

}