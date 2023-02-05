// FILE INPUT STREAM =============== THIS IS USED TO READ FROM FILE

import java.io.*;
class Inputstream {
    public static void main (String []args)throws IOException{
        File file = new File("pradip.txt");
        FileInputStream fis = new FileInputStream(file);
        int data;
        while((data = fis.read())!= -1){
            System.out.println(data);
        } 
        fis.close();  
    } 
}

// It gives the result in Bytes instead of a String so that the string "Pradip" is printed as :
// 80 ========> P
// 114 =======> r
// 97 ========> a
// 100 =======> d
// 105 =======> i
// 112 =======> p