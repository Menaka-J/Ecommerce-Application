package com.menaka.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EcartApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcartApplication.class, args);
    }

}

//HINTS:

//THE BELOW LINE USES exclude WHICH TEMPORARILY STOP SECURITY[IF ADDED IN DEPENDENCIDE]
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
