package com.capstone.productavailability.ws_product.repositories;

import com.capstone.productavailability.ws_product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
