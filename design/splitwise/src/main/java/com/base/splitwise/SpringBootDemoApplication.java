package com.base.splitwise;

import com.base.splitwise.service.api.ExpenseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootDemoApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    ExpenseService expenseService = (ExpenseService) ctx.getBean("expenseServiceImpl");

    //expenseService.addExpense();
    Arrays.sort(beanNames);

    for (String beanName : beanNames) {
      System.out.println(beanName);
    }
  }
}