import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;

class Test{
	public static void main(String [] args) throws IOException{
		Scanner s= new Scanner(System.in);
		FileOutputStream fout = new FileOutputStream("hehe.txt",true);
		System.out.println("Enter any text to write: ");
		String k=s.nextLine();
		byte[] b=k.getBytes();
		fout.write(b);
		fout.close();
		s.close();
	}
}
		