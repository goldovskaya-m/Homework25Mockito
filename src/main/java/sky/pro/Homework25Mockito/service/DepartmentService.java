package sky.pro.Homework25Mockito.service;

import org.springframework.web.bind.annotation.GetMapping;
import sky.pro.Homework25Mockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMaxSalaryEmployee(int departmentId);

    Employee getMinSalaryEmployee(int departmentId);

    double getSumSalaryEmployee(int departmentId);

    List<Employee> getAllEmployeeDepartment(int departmentId);

    Map<Integer, List<Employee>> getAllEmployees(int departmentId);
}
