
//ask user name and fav color and print name in that color

var name=prompt("Who are you?");

var color=prompt("what is your favourite color?")

var decision=confirm("Do you wish to see your name?");

if(decision){
    document.write("Your name is <span style='color:",color,"'>",name,"</span>");
}                                
else{
    document.write("Your name is *****");
}