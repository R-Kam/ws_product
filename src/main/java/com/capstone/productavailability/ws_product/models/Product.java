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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer productId;

    @NotBlank(message = "product.productName.notblank")
    String productName;

    @NotNull(message = "department.deptId.notNull")
    Integer deptId;

    @NotBlank(message = "department.name.notblank")
    String deptName;

}
