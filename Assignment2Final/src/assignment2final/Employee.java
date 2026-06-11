package assignment2final;

public class Employee {

    private int id;
    private String name;
    private double salary;

    // Biến static
    private static int employeeCount = 0;
    private static int nextId = 1000;

    public static String companyName = "TechCorp";

    private static double totalSalary = 0;

    // Constructor
    public Employee(String name, double salary) {

        this.id = nextId++;
        this.name = name;
        this.salary = salary;

        employeeCount++;
        totalSalary += salary;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double newSalary) {

        totalSalary -= salary;

        salary = newSalary;

        totalSalary += newSalary;
    }

    // Static methods
    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static double getTotalSalary() {
        return totalSalary;
    }

    public static double getAverageSalary() {

        if(employeeCount == 0){
            return 0;
        }

        return totalSalary / employeeCount;
    }

    public static void changeCompanyName(String newName){
        companyName = newName;
    }

    // Tăng lương %
    public void raiseSalary(double percent){

        double newSalary =
                salary +
                        salary * percent / 100;

        setSalary(newSalary);
    }
}