package sky.pro.Homework25Mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.Homework25Mockito.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void getMaxSalaryEmployee() {
        int department = 1;

        Employee employee1 = new Employee("Настя", "Фёдорова", department, 33000);
        Employee employee2 = new Employee("Пётр", "Иванов", department, 36000);
        Employee employee3 = new Employee("Сергей", "Тимофеев", 2, 1000000);

        when(employeeService.findAll())
                .thenReturn(List.of(employee1, employee2, employee3));

        Employee maxSalaryEmployee = departmentService.getMaxSalaryEmployee(department);
        assertEquals(maxSalaryEmployee, employee2);

    }

    @Test
    void getMinSalaryEmployee() {
        int department = 1;

        Employee employee1 = new Employee("Настя", "Фёдорова", department, 33000);
        Employee employee2 = new Employee("Пётр", "Иванов", department, 36000);
        Employee employee3 = new Employee("Сергей", "Тимофеев", 2, 10000);

        when(employeeService.findAll())
                .thenReturn(List.of(employee1, employee2, employee3));

        Employee minSalaryEmployee = departmentService.getMinSalaryEmployee(department);
        assertEquals(minSalaryEmployee, employee1);
    }

    @Test
    void getSumEmployeeDepartment() {
        int department = 1;

        Employee employee1 = new Employee("Настя", "Фёдорова", department, 33000);
        Employee employee2 = new Employee("Пётр", "Иванов", department, 36000);
        Employee employee3 = new Employee("Сергей", "Тимофеев", 2, 10000);
        List<Employee> employees = List.of(employee1, employee2);


        when(employeeService.findAll()).thenReturn(employees);

        double sumSalary = departmentService.getSumSalaryEmployee(department);

        assertEquals(sumSalary, employees.stream().mapToDouble(Employee::getSalary).sum());

    }

    @Test
    void getAllEmployeeDepartment() {
        int department = 1;

        Employee employee1 = new Employee("Настя", "Фёдорова", department, 33000);
        Employee employee2 = new Employee("Пётр", "Иванов", department, 36000);
        Employee employee3 = new Employee("Сергей", "Тимофеев", 2, 10000);

        List<Employee> employees = List.of(employee1, employee2);

        when(employeeService.findAll()).thenReturn(employees);
        List<Employee> actual = departmentService.getAllEmployeeDepartment(department);
        assertIterableEquals(employees, actual);

    }


    @Test
    void findAll() {
        int department = 1;

        Employee employee1 = new Employee("Настя", "Фёдорова", department, 33000);
        Employee employee2 = new Employee("Пётр", "Иванов", department, 36000);
        Employee employee3 = new Employee("Сергей", "Тимофеев", 2, 10000);

        List<Employee> employees = List.of(employee1, employee2, employee3);


        when(employeeService.findAll()).thenReturn(employees);

        Map<Integer, List<Employee>>allEmployees = departmentService.getAllEmployees(department);


        assertThat(allEmployees);
    }
}





