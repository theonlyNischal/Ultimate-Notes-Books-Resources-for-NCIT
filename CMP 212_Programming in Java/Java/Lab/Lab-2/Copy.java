import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

class Copy{
	public static void main(String [] args) throws IOException{
		FileInputStream fis=new FileInputStream("nature.jpg");
		FileOutputStream fout=new FileOutputStream("natureCopy.jpg");
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bot=new BufferedOutputStream(fout);
		int data;
		while((data=bis.read())!=-1){
			bot.write(data);
		}
		bot.close();
		bis.close();
		fout.close();
		fis.close();
	}
}