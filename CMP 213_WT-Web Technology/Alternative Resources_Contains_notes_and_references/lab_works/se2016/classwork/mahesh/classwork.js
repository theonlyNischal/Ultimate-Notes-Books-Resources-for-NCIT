function notempty()
{
var v1=document.getElementById("first").value;
var v2=document.getElementById("middle").value;
var v3=document.getElementById("last").value;
var v4=document.getElementById("email").value;
var v5=document.getElementById("password").value;
var v6=document.getElementById("repassword").value;
var v7=document.getElementById("phone").value;
if((v1.length==0) || (v2.length==0) || (v3.length==0) || (v4.length==0) || (v5.length==0) || (v6.length==0) || (v7.length==0))
{
alert("all field must be filled");
}}
function validatefirst()
{
var x=/^[a-zA-Z]+$/;
var v=document.getElementById("first").value;
z=v.length;
if(v.match(x) && z<10)
{
alert("valid first name");
}
else
{
alert("invalid first name");
document.getElementById("first").value="";
document.getElementById("first").focus();
}
}


function validatemiddle()
{
var x=/^[a-zA-Z]+$/;
var v=document.getElementById("middle").value;
z=v.length;
if(v.match(x) && z<10)
{
alert("valid middle name");
}
else
{
alert("invalid middle name");
document.getElementById("middle").value="";
document.getElementById("middle").focus();
}}


function validatelast()
{
var x=/^[a-zA-Z]+$/;
var v=document.getElementById("last").value;
z=v.length;
if(v.match(x) && z<10)
{
alert("valid last name");
}
else
{
alert("invalid last name");
document.getElementById("last").value="";
document.getElementById("last").focus();
}}



function validateemail()
{
var x=/^[/w/-/./+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
var v=document.getElementById("email").value;
z=v.length;
if(v.match(x) && z<40)
{
alert("valid e-mail");
}
else
{
alert("invalid email");
document.getElementById("email").value="";
document.getElementById("email").focus();
}}



function validatepassword()
{
var x=/^[0-9]+$/;
var v=document.getElementById("password").value;
z=v.length;
if(v.match(x) && z<100)
{
alert("valid password");
}
else
{
alert("invalid password");
document.getElementById("password").value="";
document.getElementById("password").focus();
}}


function validaterepassword()
{
var x=/^[0-9]+$/;
var v=document.getElementById("repassword").value;
var z=document.getElementById("password").value
if(v.match(x) && z==v)
{
alert("password match");
}
else
{
alert("password do not match");
document.getElementById("repassword").value="";
document.getElementById("repassword").focus();
}}




function validatephone()
{
var x=/^[0-9]+$/;
var v=document.getElementById("phone").value;
if(v.match(x))
{
alert("valid phone number");
}
else
{
alert("invalid phone number");
document.getElementById("phone").value="";
document.getElementById("phone").focus();
}}



































