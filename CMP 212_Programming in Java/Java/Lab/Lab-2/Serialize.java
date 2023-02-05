import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

class Student implements Serializable{
	String name;
	int roll;
	public Student(String name, int roll){
		this.name=name;
		this.roll=roll;
	}
	public void getDetails(){
		System.out.println("Name: "+this.name+"\nRoll: "+this.roll);
	}
}
class Serialize{
	void serialize() throws IOException{
		Student s= new Student("Kamal", 12);
		FileOutputStream fout=new FileOutputStream("data.txt");
		ObjectOutputStream os=new ObjectOutputStream(fout);
		os.writeObject(s);
		os.close();
		fout.close();
	}
	void deserialize() throws IOException, ClassNotFoundException{
		FileInputStream fis=new FileInputStream("data.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Student st= (Student)ois.readObject();
		st.getDetails();
		ois.close();
		fis.close();
	}
	public static void main(String [] args) throws IOException, ClassNotFoundException{
		Serialize se=new Serialize();
		se.serialize();
		se.deserialize();
	}
}