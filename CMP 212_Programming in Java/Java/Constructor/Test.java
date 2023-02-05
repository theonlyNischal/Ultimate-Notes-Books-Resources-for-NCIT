class Employee
{
    int roll;
    String name;

    public Employee(int roll,String name)
    {
        this.name=name;
        this.roll=roll;
    }
    @Override
    public String toString()
    {
        return "Id = "+this.roll+"\nName = "+this.name;
    }
}

class Test{
    public static void main(String []args)
    {
        Employee e = new Employee(11,"Pradip Dhungana");
        System.out.println(e);
    }
}