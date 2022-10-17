
var num=prompt("enter a number");

document.write("<table border='1' cellspacing='0'>");
for(var i=1;i<=10;i++){
document.write("<tr><td>",num,"*",i,"</td><td>",(num*i),"</td></tr>")
}
document.write("</table>")