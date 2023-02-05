class Employee{
	String id, name, post;
	int salary;
	public Employee(String id, String name, String post, int salary){
		this.id=id;
		this.name=name;
		this.post=post;
		this.salary=salary;
	}
	public String toString(){
		return "Name: "+this.name+" \nID: "+this.id+"\nPost: "+this.post+" \nSalary: "+this.salary;
	}
}
class Publish{
	public static void main(String [] args){
		Employee e=new Employee("F9","Kamal","Instructor",15000);
		System.out.println(e);
	}
}