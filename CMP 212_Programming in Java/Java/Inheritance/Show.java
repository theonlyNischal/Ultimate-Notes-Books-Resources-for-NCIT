import p1.*;
class Child extends Checking{
	public void display(){
		Checking ch=new Checking();
		System.out.println("Inherited " + ch.s3);
	}
}
class Show{
	public static void main(String[] args){
		Child c=new Child();
		c.display();
		Checking cn=new Checking();
		System.out.println(cn.s4);
	}
}