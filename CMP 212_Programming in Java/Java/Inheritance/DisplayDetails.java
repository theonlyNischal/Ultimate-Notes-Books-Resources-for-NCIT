class Storage{
	int memory;
	boolean hdd;
	public Storage(int memory, boolean hdd){
		this.memory=memory;
		this.hdd=hdd;
	}
	public void getDetails(){
		System.out.println("Is HDD? "+this.hdd+"  Memory: "+this.memory);
	}
}
class Computer{
	String brand;
	int price;
	Storage str;
	public Computer(String brand, int price, Storage str){
		this.brand=brand;
		this.price=price;
		this.str=str;
	}
	public void showDetails(){
		System.out.println("Brand: "+this.brand+"\nPrice: "+this.price);
		this.str.getDetails();
	}
}
class DisplayDetails{
	public static void main(String [] args){
		Storage s=new Storage(30,true);
		Computer c=new Computer("Dell", 45000, s);
		c.showDetails();
	}
}