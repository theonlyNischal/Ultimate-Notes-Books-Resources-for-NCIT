
document.getElementById('lqty').onchange=calcLtotal;
document.getElementById('mqty').onchange=calcMtotal;    
document.getElementById('totalBtn').onclick=calcTotal;

document.getElementById('blue').onclick=changeBlue;
document.getElementById('red').onclick=changeRed;

function changeBlue(){
    document.getElementById('myTable').style.borderColor="blue";
}
function changeRed(){
    document.getElementById('myTable').style.borderColor="red";
}



var ltotal=0;
var mtotal=0;
function calcLtotal(){

    var lqty=document.getElementById('lqty').value;
    ltotal=lqty*100000;
    document.getElementById('ltotal').value=ltotal; 
}
function calcMtotal(){
    var mqty=document.getElementById('mqty').value;
    mtotal=mqty*50000;
    document.getElementById('mtotal').value=mtotal;
}
function calcTotal(){
    var totalCost=mtotal+ltotal;
    document.getElementById('total').value=totalCost;
}