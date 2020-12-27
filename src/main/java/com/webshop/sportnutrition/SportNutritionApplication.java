package com.webshop.sportnutrition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SportNutritionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportNutritionApplication.class, args);
    }

}
