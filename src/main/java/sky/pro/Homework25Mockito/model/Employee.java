package sky.pro.Homework25Mockito.model;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private int departmentId;
    private double salary;

    public Employee(String lastName, String firstName) {

        this.lastName = lastName;
        this.firstName = firstName;
       // this.departmentId = departmentId;
       // this.salary = salary;


    }

    public Employee(String lastName, String firstName, int departmentId, double salary) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.departmentId = departmentId;
        this.salary = salary;

    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public String getAllFields() {
        return " ФИО " + lastName + firstName;

    }

    @Override
    public String toString() {
        return String.format(" ФИО " + lastName + firstName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return firstName.equals(employee.firstName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
