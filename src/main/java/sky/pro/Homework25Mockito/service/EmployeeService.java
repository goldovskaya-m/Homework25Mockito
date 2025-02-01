package sky.pro.Homework25Mockito.service;

import sky.pro.Homework25Mockito.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentId, double salary);
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName, int departmentId, double salary);
    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName, int departmentId, double salary);

    Collection<Employee> findAll();
}





