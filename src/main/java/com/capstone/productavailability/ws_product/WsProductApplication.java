package com.capstone.productavailability.ws_product;

import com.capstone.productavailability.ws_product.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class WsProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsProductApplication.class, args);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Product product = Product.builder().productId(1).productName("Prod Test 1")
//                .build();
//
        log.info("Ws Product running +++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
