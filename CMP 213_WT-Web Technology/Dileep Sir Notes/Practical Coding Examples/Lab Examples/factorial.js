
var num=prompt("Enter a number");

var fact=1;
var count=1;

while(count<num){
    count++;
    fact=fact*count;
}

//alert("the factorial of "+num+" is "+fact);
document.write("the factorial of "+num+" is "+fact);

