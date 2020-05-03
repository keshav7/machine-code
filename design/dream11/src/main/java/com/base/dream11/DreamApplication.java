package com.base.dream11;

import com.base.dream11.service.api.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DreamApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(DreamApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    ManagerService managerService = (ManagerService) ctx.getBean("managerServiceImpl");

    managerService.initialise();
    //Arrays.sort(beanNames);
    //
    //for (String beanName : beanNames) {
    //  System.out.println(beanName);
    //}
  }
}