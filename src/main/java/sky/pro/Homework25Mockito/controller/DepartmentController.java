package sky.pro.Homework25Mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.Homework25Mockito.model.Employee;
import sky.pro.Homework25Mockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}/salary/max")
    public Employee getMaxSalaryEmployee(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getMaxSalaryEmployee(departmentId);

    }

    @GetMapping("/department/{id}/salary/min")
    public Employee getMinSalaryEmployee(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getMinSalaryEmployee(departmentId);

    }

    @GetMapping("/department/{id}/salary/sum")

    public ResponseEntity<Double> getSumSalaryEmployee(@PathVariable Integer departmentId) {
        double sum = departmentService.getSumSalaryEmployee(departmentId);
        return ResponseEntity.ok((sum));

    }


    @GetMapping("/department/{id}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Integer id) {
        List<Employee> employees = departmentService.getAllEmployeeDepartment(id);
        return ResponseEntity.ok(employees);

    }

    @GetMapping("/department/{id}/all/by-department")
    public List<Employee> getAllEmployeeDepartment(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getAllEmployeeDepartment(departmentId);

    }

    @GetMapping("/department/{id}/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();

    }
}
