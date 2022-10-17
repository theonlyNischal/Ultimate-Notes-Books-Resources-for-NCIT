
document.getElementById("myform").onsubmit=checkpass;

 function checkpass(){

    var pass1=document.getElementById("pass1").value;
    var pass2=document.getElementById("pass2").value;

    if(pass1=='' || pass2==''){
        alert('both fields should not be empty');
        return false;
    }
    else{
        //check whether both values are equal or not

        if(pass1!== pass2){
            alert("the two passwords doesn't match!");
            return false;
        }
        else{
            alert("matched!!!");
            return true;
        }

    }

    

}