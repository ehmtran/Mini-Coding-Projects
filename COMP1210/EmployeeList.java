import java.util.ArrayList;

public class Employee {
    // Create Base Class Employee
    // fields: name, employeeid, salary
    protected String name;
    protected int employeeId;
    protected double salary;
    // methods: displayinfo() - prints employee info
    // calculateBonus() - calculates default bonus

    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Employee: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Salary: $" + salary);
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

}

class Manager extends Employee {
    // Create subclass Manager that extends Employee
    // additional field: teamSize
    private int teamSize;

    public Manager(String name, int employeeId, double salary, int teamSize) {
        super(name, employeeId, salary);
        this.teamSize = teamSize;
    }

    // override displayInfo() to include team size
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Team Size: " + teamSize);
    }

    // override calculateBonus(), use team size
    @Override
    public double calculateBonus() {
        return salary * 0.10 + teamSize * 100.0;
    }
}

class Developer extends Employee {
    // Create subclass Developer that extends Employee
    // additional field: programmingLanguage
    private String programmingLanguage;

    public Developer(String name, int employeeId, double salary, String programmingLanguage) {
        super(name, employeeId, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // override displayInfo() to include programming language
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
    }

    // override calculateBonus(), higher perc than base (10%?)
    @Override
    public double calculateBonus() {
        return salary * 0.08;
    }
}

public class EmployeeList {

    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        Employee emp1 = new Manager("Alice", 101, 90000, 5);
        Employee emp2 = new Developer("Bob", 102, 80000, "Java");

        employeeList.add(emp1);
        employeeList.add(emp2);

        for (Employee emp : employeeList) {
            emp.displayInfo();
            System.out.println("Bonus: $" + emp.calculateBonus());
            System.out.println("-----------------------");
        }
    }
}