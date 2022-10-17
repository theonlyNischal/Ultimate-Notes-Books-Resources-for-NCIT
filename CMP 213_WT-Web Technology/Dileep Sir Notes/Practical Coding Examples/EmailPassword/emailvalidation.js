document.getElementById("email").onchange = checkemail;
document.getElementById("password2").onchange = checkpassword;
document.getElementById('myform').onsubmit = checkpassword;

function checkemail() {
  var useremail = document.getElementById("email")

  //check whether email is empty or not
  if (useremail.value == "") {
    document.getElementById("emailerr").innerText =
      "Email field cannot be empty"
  } else {
    //check email format(pattern)    abc@gmail.com     (/^\w+@\w+\.\[a-Z]{2,3}$/)
    var pos = useremail.value.search(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)

    if (pos !== 0) {
      //email format is bot valid
      document.getElementById("emailerr").innerText = "Invalid email format"
    } else {
      document.getElementById("emailerr").innerText = "Email validated"
    }
  }
}
function checkpassword() {
  var password1 = document.getElementById("password1").value
  var password2 = document.getElementById("password2").value

  if (password1 == "" || password2 == "") {
    //alert('both fields should not be empty');
    document.getElementById("passerr").innerText =
      "password fields cannot be empty";
    return false;
  } else {
    //check whether both values are equal or not

    if (password1 == password2) {
      document.getElementById("passerr").innerText = "password validated";

    } else {
      document.getElementById("passerr").innerText = "passwords does not match";
      return false;
    }
  }
}
