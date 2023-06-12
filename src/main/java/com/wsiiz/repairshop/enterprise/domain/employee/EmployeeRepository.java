package com.wsiiz.repairshop.enterprise.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    @Query("select e from Employee e where (:branchIdEmployee = null or e.branchIdEmployee = :branchIdEmployee)")
    List<Employee> findByCriteriaBranchID(@Param("branchIdEmployee") Long branchIdEmployee);


}
