package org.cwc.productservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ProductServiceSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceSpringbootApplication.class, args);
        log.info("Product Service Started");
    }
}