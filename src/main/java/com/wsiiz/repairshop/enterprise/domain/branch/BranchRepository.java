package com.wsiiz.repairshop.enterprise.domain.branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch,Long>, JpaSpecificationExecutor<Branch> {

    @Query("select b from Branch b where (:branchId = null or b.branchId = :branchId) "
            + "and (:city = null or b.address.city = :city)")
    List<Branch> findByBranchCityCriteria(@Param("branchId") Long branch_id, @Param("city") String city);

}
