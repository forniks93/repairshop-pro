package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeService;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/enterprise/employee")
    public ResponseEntity<List<Employee>> getMany(
            @RequestParam(value = "branchIdEmployee", required = false) Long branchIdEmployee) {
        return ResponseEntity.ok(employeeRepository.findByCriteriaBranchID(branchIdEmployee));
    }

    @GetMapping("/api/enterprise/employee/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {
        return employeeRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/enterprise/employee")
    public ResponseEntity<Employee> addNew(@RequestBody Employee employee) {
        return ResponseEntity.created(null).body(employeeService.add(employee));
    }

    @DeleteMapping("/api/enterprise/employee/{id}")
    public ResponseEntity<Employee> remove(@PathVariable("id") Long id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if(!employee.isPresent()){
            return ResponseEntity.notFound().build();
        }
        employeeService.delete(id);
        return ResponseEntity.ok(employee.get());
    }
}


