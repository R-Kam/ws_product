package com.capstone.productavailability.ws_product.controllers;

import com.capstone.productavailability.ws_product.models.Product;
import com.capstone.productavailability.ws_product.services.ProductService;
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
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        log.info("saveDepartment : {}", product);
        Product dept = productService.saveProduct(product);
        if(Objects.nonNull(dept)) {
            log.info("Succesfull record : {}", dept);
            return new ResponseEntity<>(dept, HttpStatus.CREATED);
        }
        else {
            log.error("Product not saved : {}", product);
            return new ResponseEntity<>(product,HttpStatus.BAD_REQUEST);
        }
    }
}
