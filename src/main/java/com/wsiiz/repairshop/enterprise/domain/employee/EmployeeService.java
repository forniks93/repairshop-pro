package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeService implements AbstractService<Employee> {

    final EmployeeRepository employeeRepository;

    @Override
    public JpaRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }

    @Override
    public JpaSpecificationExecutor<Employee> getSpecificationExecutor() {
        return employeeRepository;
    }
}
