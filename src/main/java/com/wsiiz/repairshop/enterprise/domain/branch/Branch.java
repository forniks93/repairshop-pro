package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = true)
public class Branch extends BaseEntity {
    String nameBranch;
    long branchId;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    ActivityType activityType;

    @OneToMany(mappedBy = "branch",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Employee> employeeList;
}
