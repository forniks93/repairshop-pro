package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    BranchService branchService;

    @GetMapping("/api/enterprise/branch")
    public ResponseEntity<List<Branch>> getMany(
            @RequestParam(value = "branch_id", required = false) Long branchId,
            @RequestParam(value = "city",required = false) String city)
    {
        return ResponseEntity.ok(branchRepository.findByBranchCityCriteria(branchId,city));
    }

    @GetMapping("/api/enterprise/branch/{id}")
    public ResponseEntity<Branch> getOne(@PathVariable("id")Long id){
        return branchRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/enterprise/branch")
    public ResponseEntity<Branch> addNew(@RequestBody Branch branch){
        return ResponseEntity.created(null).body(branchService.add(branch));
    }

    @DeleteMapping("/api/enterprise/branch/{id}")
    public ResponseEntity<Branch> remove(@PathVariable("id") Long id){
        Optional<Branch> branch = branchRepository.findById(id);

        if(!branch.isPresent()){
            return ResponseEntity.notFound().build();
        }
        branchService.delete(id);
        return ResponseEntity.ok(branch.get());
    }
}
