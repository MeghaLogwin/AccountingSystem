package com.companyaccounting.controller;

import com.companyaccounting.dto.CompanyRequest;
import com.companyaccounting.dto.DepartmentRequest;
import com.companyaccounting.entity.Owner;
import com.companyaccounting.service.OwnerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner/plan")
public class OwnerPlansController {

    @Autowired
    private OwnerPlanService ownerPlanService;

    @PostMapping("/save")
    public Owner saveOwnerWithPlan(@RequestBody Owner owner){

        return ownerPlanService.saveOwnerWithPlan(owner);
    }

    @GetMapping("/findAll")
    public List<Owner> findAllOwners(){

        return ownerPlanService.findAllOwners();
    }

    @GetMapping("/{ownerId}")
    public Owner findOwner(@PathVariable Long ownerId){

        return ownerPlanService.findOwner(ownerId);
    }

    // Save the Owners Company
    @PostMapping("/saveCompany")
    public Owner saveCompany(@RequestBody CompanyRequest companyRequest){
        return ownerPlanService.saveCompany(companyRequest);
    }

    @GetMapping("/findAllCompanies")
    public List<Owner> findAllCompanies(){
        return ownerPlanService.findAllCompanies();
    }

    @PostMapping("/saveDepartment")
    public Owner saveDepartment(@RequestBody DepartmentRequest departmentRequest){
        return ownerPlanService.saveDepartment(departmentRequest);
    }

    @GetMapping("/findAllDepartments")
    public List<Owner> findAllDepartments(){
        return ownerPlanService.findAllDepartments();
    }

}
