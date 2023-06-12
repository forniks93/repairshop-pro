package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = true)
public class EmployeeSkill extends BaseEntity {
    private Long skillsID;
    private String skillsNames;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
