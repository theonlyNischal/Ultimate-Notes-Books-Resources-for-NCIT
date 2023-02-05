// WAP to serialize an object & write into a file.

package Serialization;

import java.io.*;

class Student implements Serializable{
    int roll;
    String name;
    public Student(int roll, String name){
        this.roll=roll;
        this.name=name;
    }
    public void show(){
        System.out.println("Student Details : "+" Roll =  "+this.roll+"Name = "+this.name);
    }
}
class Serialize {
    public static void main(String[] args) throws IOException{
        Student s = new Student(1, "Pradip Dhungana");
        FileOutputStream fos = new FileOutputStream("Object.dat");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(s);
        os.close();
        fos.close();
    }
}
class Deserialize {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        FileInputStream fis = new FileInputStream("Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student obj = (Student) ois.readObject();
        obj.show();
        ois.close();
        fis.close();
    }
}