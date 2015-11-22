package com.alchemytec.app;

/**
 * Date: 21-Nov-2015
 * Author: senthil  
 **/
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExpenseApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ExpenseApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}
