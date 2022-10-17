document.getElementById("r1").onclick = msg;
document.getElementById("r2").onclick = msg;

function msg() {
    console.log('function called');
    var x='';
  var formObj = document.getElementById("myform");

  for (var i = 0; i < formObj.fruit.length; i++) {
    if (formObj.fruit[i].checked) {
      x = formObj.fruit[i].value;
      break;
    }
  }

  
document.getElementById("radiomessage").innerText ="Your choice was "+x;
  
}
