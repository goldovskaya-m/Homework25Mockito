package sky.pro.Homework25Mockito.controller;

import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Homework25Mockito.model.Employee;
import sky.pro.Homework25Mockito.service.EmployeeService;
import sky.pro.Homework25Mockito.exception.InvalidNameException;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return service.add(firstName, lastName);
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return service.find(firstName, lastName);
    }
    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
