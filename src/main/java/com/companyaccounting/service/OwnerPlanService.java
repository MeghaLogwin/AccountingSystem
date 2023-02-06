package com.companyaccounting.service;

import com.companyaccounting.dto.CompanyRequest;
import com.companyaccounting.dto.DepartmentRequest;
import com.companyaccounting.entity.Owner;

import java.util.List;

public interface OwnerPlanService {
    public Owner saveOwnerWithPlan(Owner owner);
    public List<Owner> findAllOwners();
    public Owner findOwner(Long ownerId);

    public Owner saveCompany(CompanyRequest companyRequest);

    public List<Owner> findAllCompanies();

    public Owner saveDepartment(DepartmentRequest departmentRequest);

    public List<Owner> findAllDepartments();

   /* public Owner SaveUser(UserRequest userRequest);

    public List<Owner> findAllUsers();*/
}
