package DefiningClasses.CompanyRoster;

class Employee {
    private static final String UNDEFINED_EMAIL = "n/a";
    private static final int UNDEFINED_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email != null ? email : UNDEFINED_EMAIL;
        this.age = age != null ? age : UNDEFINED_AGE;
    }

    double getSalary() { return salary; }
    String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
