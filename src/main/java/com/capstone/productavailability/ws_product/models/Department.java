package com.capstone.productavailability.ws_product.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
//@Entity
public class Department {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    Integer deptId;
//
//    @NotBlank(message = "department.name.notblank")
//    String deptName;

//    @OneToMany(mappedBy="department", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Product> productSet;
}
