package com.companyaccounting.service;

import com.companyaccounting.dto.CompanyRequest;
import com.companyaccounting.dto.DepartmentRequest;
import com.companyaccounting.entity.Company;
import com.companyaccounting.entity.Owner;
import com.companyaccounting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Owner saveOwnerWithPlan(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findOwner(Long ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public Owner saveCompany(CompanyRequest companyRequest) {

        return ownerRepository.save(companyRequest.getOwner());
    }

    @Override
    public List<Company> findAllCompanies() {

        return companyRepository.findAll();
    }

    @Override
    public Owner saveDepartment(DepartmentRequest departmentRequest) {
        return ownerRepository.save(departmentRequest.getOwner());
    }

    @Override
    public List<Owner> findAllDepartments() {

        return ownerRepository.findAll();
    }
/*
    @Override
    public Owner SaveUser(UserRequest userRequest) {
        return ownerRepository.save((userRequest.getOwner()));
    }

    @Override
    public List<Owner> findAllUsers() {
        return ownerRepository.findAll();
    }*/
}
