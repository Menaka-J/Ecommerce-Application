package com.menaka.ecart;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class EcartApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMalformed().ignoreIfMissing().load();

        if (dotenv.get("DB_URL") != null) {
            System.setProperty("DB_URL", dotenv.get("DB_URL"));
        }
        if (dotenv.get("DB_USER") != null) {
            System.setProperty("DB_USER", dotenv.get("DB_USER"));
        }
        if (dotenv.get("DB_PASS") != null) {
            System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
        }

        //run
        SpringApplication.run(EcartApplication.class, args);
    }

}

//HINTS:

//THE BELOW LINE USES exclude WHICH TEMPORARILY STOP SECURITY[IF ADDED IN DEPENDENCIDE]
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
