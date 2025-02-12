package sky.pro.Homework25Mockito.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import sky.pro.Homework25Mockito.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Double.sum;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private  final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalaryEmployee(int departmentId) {

        return employeeService.findAll().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.findAll().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public double getSumSalaryEmployee(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    /**
     * вернет всех сотрудников
     */
    @Override
    public List<Employee> getAllEmployeeDepartment(int departmentId) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees( int departmentId) {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy
                (Employee::getDepartmentId));

    }
}
