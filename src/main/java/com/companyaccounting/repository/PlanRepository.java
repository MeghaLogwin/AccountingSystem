package com.companyaccounting.repository;

import com.companyaccounting.entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plans,Long> {
}
