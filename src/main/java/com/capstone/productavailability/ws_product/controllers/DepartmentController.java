package com.capstone.productavailability.ws_product.controllers;

import com.capstone.productavailability.ws_product.models.Department;
import com.capstone.productavailability.ws_product.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@Slf4j
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDept")
    public ResponseEntity<Department> saveDepartment(@RequestBody @Valid Department department){
        log.info("saveDepartment : {}", department);
        Department dept = departmentService.saveDepartment(department);
        if(Objects.nonNull(dept)) {
            log.info("Succesfull record : {}", dept);
            return new ResponseEntity<>(dept,HttpStatus.CREATED);
        }
        else {
            log.error("Department not saved : {}", department);
            return new ResponseEntity<>(department,HttpStatus.BAD_REQUEST);
        }
    }
}
