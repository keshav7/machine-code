package com.base.callaggregator;

import com.base.callaggregator.service.api.ManagerSevice;
import com.base.callaggregator.service.impl.ManagerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CallApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(CallApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    ManagerSevice managerService = (ManagerServiceImpl) ctx.getBean("managerServiceImpl");

    managerService.initialise();


  }

}