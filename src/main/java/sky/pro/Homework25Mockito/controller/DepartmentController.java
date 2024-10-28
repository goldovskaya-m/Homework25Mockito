package sky.pro.Homework25Mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Homework25Mockito.model.Employee;
import sky.pro.Homework25Mockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public  DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("departmentId") int departmentId) {
        return departmentService.getMaxSalaryEmployee(departmentId);

    }
    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("departmentId") int departmentId) {
        return departmentService.getMinSalaryEmployee(departmentId);

    }
    @GetMapping("/all/dy-department")
    public List<Employee> getAllEmployeeDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.getAllEmployeeDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();

    }
}
