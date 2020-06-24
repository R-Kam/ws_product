package com.capstone.productavailability.ws_product.services;

import com.capstone.productavailability.ws_product.models.Product;
import com.capstone.productavailability.ws_product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        try{
            return productRepository.save(product);
        }catch (Exception e){
            return null;
        }
    }

    public void deleteProduct(Product product){
        try{
            productRepository.delete(product);
        }catch (Exception e){}
    }
}
