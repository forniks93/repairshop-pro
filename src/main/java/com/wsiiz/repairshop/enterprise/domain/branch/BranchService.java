package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchService implements AbstractService<Branch> {

    final BranchRepository branchRepository;

    @Override
    public JpaRepository<Branch, Long> getRepository() {
        return branchRepository;
    }

    @Override
    public JpaSpecificationExecutor<Branch> getSpecificationExecutor() {
        return branchRepository;
    }
}
