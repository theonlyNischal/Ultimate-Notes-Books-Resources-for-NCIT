class Employee{
	String id, name;
	int mSalary;
	public Employee(String id, String name, int mSalary)
	{
		this.id=id;
		this.name=name;
		this.mSalary=mSalary;
	}
	public int getYearlySalary(){
		return this.mSalary*12;
	}
}
class Teacher extends Employee{
	int nSub;
	public Teacher(String id, String name, int mSalary, int nSub){
		super(id,name,mSalary);
		this.nSub=nSub;
	}
	public int getYearlySalary(){
		return super.getYearlySalary()+nSub*1000;
	}
	public void getDetails(){
		System.out.println(this.name);
		System.out.println(this.id);
	}
}
class Testinherit{
	public static void main(String [] args){
		Teacher t=new Teacher("K1","Kamal",15000,6);
		t.getDetails();
		System.out.println("Yearly salary: ");
		System.out.println(t.getYearlySalary());
	}
}