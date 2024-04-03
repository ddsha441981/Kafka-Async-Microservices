package org.cwc.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UserServiceSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceSpringbootApplication.class, args);
        log.info("User Service Started");
    }
}