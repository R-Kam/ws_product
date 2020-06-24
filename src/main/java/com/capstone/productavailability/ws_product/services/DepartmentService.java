package com.capstone.productavailability.ws_product.services;

import com.capstone.productavailability.ws_product.models.Department;
import com.capstone.productavailability.ws_product.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        try{
            return departmentRepository.save(department);
        }catch (Exception e){
            return null;
        }
    }

    public void deleteDepartment(Department department){
        try{
             departmentRepository.delete(department);
        }catch (Exception e){}
    }
}
