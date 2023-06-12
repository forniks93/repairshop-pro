package com.wsiiz.repairshop.enterprise.domain.branch;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    String city;
    String street;
    String province;
}
