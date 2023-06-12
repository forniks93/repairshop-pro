package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = true)
public class Employee extends BaseEntity {
    private String firstName;
    private String surName;
    Long branchIdEmployee;
    LocalDate hireStart;

    @Enumerated(EnumType.STRING)
    EmploymentType employmentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    List<Employee> skills;
}
