package sky.pro.Homework25Mockito.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import sky.pro.Homework25Mockito.exception.EmployeeAlreadyAddedException;
import sky.pro.Homework25Mockito.exception.EmployeeNotFoundException;
import sky.pro.Homework25Mockito.exception.InvalidNameException;
import sky.pro.Homework25Mockito.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {

        this.employees = new HashMap<>();
    }
    @Override

    public Employee add(String firstName, String lastName, int departmentId, double salary) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(lastName, firstName,  departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override

    public Employee add(String firstName, String lastName) {
        return add(firstName, lastName, 0, 0);

    }

    @Override

    public Employee remove(String firstName, String lastName, int departmentId, double salary) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {

            // employees.remove(employee.getFullName());
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override

    public Employee remove(String firstName, String lastName) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {

            // employees.remove(employee.getFullName());
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override

    public Employee find(String firstName, String lastName, int departmentId, double salary) {
        validateNames(firstName, lastName);
        Employee employee = new Employee(lastName, firstName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    private void validateNames(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidNameException(firstName);
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidNameException(lastName);
        }

    }
}
