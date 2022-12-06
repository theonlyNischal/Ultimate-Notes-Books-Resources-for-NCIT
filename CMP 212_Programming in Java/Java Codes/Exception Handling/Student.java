// Create a class Student with name and semester as attributes also create a custom exception class called SemesterException which
//  will be thrown when value assigned to semester is Invalid

import java.util.Scanner;

class Student{
    String name;
    int semester;
    Student(String name, int semester){
        this.name = name;
        this.semester = semester;
    }
    void display(){
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name of the Student");
        String name = sc.nextLine();
        System.out.println("Enter the Semester of the Student");
        int semester = sc.nextInt();
        try{
            if(semester < 1 || semester > 8){
                throw new SemesterException("Invalid Semester");
            }
            else{
                Student s = new Student(name, semester);
                s.display();
            }
        }
        catch(SemesterException ex){
          
            System.out.println(ex);
        }
    }
}

class SemesterException extends Exception {
    public SemesterException(String message) {
        super(message);
    }
}
