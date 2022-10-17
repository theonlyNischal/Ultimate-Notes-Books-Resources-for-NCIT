document.getElementById('btn').onclick=changeVisibility

function changeVisibility(){

    var obj=document.getElementById('mybox');

    if(obj.style.visibility=='visible'){
        obj.style.visibility='hidden';
    }
    else{
        obj.style.visibility='visible';
    }
}