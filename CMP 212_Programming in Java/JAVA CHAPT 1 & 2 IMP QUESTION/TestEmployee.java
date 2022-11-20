class Employee {
    String id, name, post;
    double salary;

    public Employee(String id, String name, String post, double sal) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.salary = sal;
    }

    public String toString() {
        return id + " " + name + " " + post + " " + salary;

    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Employee e = new Employee("24443", "isha", "data-engineer", 45000.89);
        System.out.println(e);
    }
}
