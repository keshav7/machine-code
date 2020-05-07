package com.base.cab_book;

import com.base.cab_book.service.api.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CabApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(CabApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    ManagerService managerService = (ManagerService) ctx.getBean("managerServiceImpl");

    managerService.initialise();


  }








  
}