package com.companyaccounting.repository;

import com.companyaccounting.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
