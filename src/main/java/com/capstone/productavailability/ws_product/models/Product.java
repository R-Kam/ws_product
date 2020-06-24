package com.capstone.productavailability.ws_product.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer productId;

    @NotBlank(message = "product.productName.notblank")
    String productName;

    Integer deptId;

    @NotBlank(message = "department.name.notblank")
    String deptName;

//    @NotNull(message = "product.deptId.notblank")
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name="deptId", nullable=false)
//    Department department;
}
