// 2018 FALL (3b)

// A data file emp.txt contains the following data: name address and salary of 30 Employees.
//  Write a program to display only those records whoo are from Kathmandu.


// REMINDER : This CODE WILL NOT RUN CAUSE THIS QUESTION IS ASKED IN EXAM 
// AND WE ASSUMED THAT THE "emp.txt" FILE ALREADY ALREADY EXISTS WE WILL JUST DEMONSTRATE THE PROGRAM :)

import java.io.*;

public class Employee {
    public static void main (String []args)throws IOException{
        FileInputStream fis = new FileInputStream("emp.txt");
        DataInputStream dis = new DataInputStream(fis);
        while(dis.available() > 0){
            String name = dis.readUTF();
            String address = dis.readUTF();
            int salary = dis.readInt();
            if(address.toLowerCase().equals("Kathmandu")){
                System.out.println("Name = "+name+ "Address = " +address+"Salary = "+salary);
            }
        }
        dis.close();
        fis.close();
    }
}

// OUTPUT : Java/File Handeling/Old Questions Solved/" && javac Employee.java && java Employee
// Exception in thread "main" java.io.FileNotFoundException: emp.txt (No such file or directory)