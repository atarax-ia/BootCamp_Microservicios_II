package com.everis.bootcamp.employeeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControler {
    private final EmployeeRepository repository;

    public EmployeeControler(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/employees")
    public List<Employee> getAllEmployes() {
        for(Employee e : repository.findAll()) {
            e.setName(e.getName() + " " + serverPort);
        }

        return repository.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return this.repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        Employee emp = new Employee("","",0);
        emp.setId(0L);
        try {
            return this.repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        } catch (EmployeeNotFoundException exc) {
            return emp;
        }
    }

    @PutMapping("/employees/{id}")
    public Employee addOrUpdateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return this.repository.findById(id).map(
                (emp) -> {
                    emp.setName(employee.getName());
                    emp.setRole(employee.getRole());
                    emp.setSueldo(employee.getSueldo());
                    return repository.save(emp);
                }).orElseGet(
                () -> {
                    employee.setId(id);
                    return this.repository.save(employee);
                }
        );
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        this.repository.deleteById(id);
    }
}
