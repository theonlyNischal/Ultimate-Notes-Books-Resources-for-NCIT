
//get the target nodes 
var nameNode=document.getElementById("name");
var phNode=document.getElementById("phone");

//registering event handlers acc. to dom 2 event model

nameNode.addEventListener("change",checkName,false);
phNode.addEventListener("change",checkPhone,false);


function checkName(event){
    //get the target node
    var name=event.currentTarget;

    //validate the name

    var pos=name.value.search(/^[A-Za-z]+\s[A-Za-z]+(\s[A-Z]+)?$/);

if(pos !=0 ){
        document.getElementById("errname").innerText="Name format is incorrect";
    }
    else{
        document.getElementById("errname").innerText="Name format is Correct";
    }

}

function checkPhone(event){
    //get the target node
    var ph=event.currentTarget;

    var pos=ph.value.search(/^00977-\d{3}-\d{7}$/);

    if(pos!=0){
        document.getElementById("errph").innerText="Phone format is incorrect";
    }
    else{
        document.getElementById("errph").innerText="Phone format is correct";
    }

}