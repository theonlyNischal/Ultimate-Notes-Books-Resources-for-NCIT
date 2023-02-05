class Address{
	String city;
	int ward;
	public Address(String city, int ward){
		this.city=city;
		this.ward=ward;
	}
	public void getAddress(){
		System.out.println("City: " + this.city  +"Ward: "+this.ward);
	}
}
class Student{
	String name;
	int roll;
	Address addr;
	public Student(String name, int roll, Address addr)
	{
		this.name=name;
		this.roll=roll;
		this.addr=addr;
	}
	public void getDetails(){
		System.out.println("Name: "+this.name+" Roll: "+this.roll);
		this.addr.getAddress();
	}
}
class Composition{
	public static void main(String[] args){
		Address a = new Address("Dhg",01);
		Student s = new Student("Kamal",12,a);
		s.getDetails();
	}
}

		
