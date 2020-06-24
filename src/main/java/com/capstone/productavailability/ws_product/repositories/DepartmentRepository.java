package com.capstone.productavailability.ws_product.repositories;

import com.capstone.productavailability.ws_product.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
