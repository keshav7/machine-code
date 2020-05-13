package com.base.cabby;

import com.base.cabby.service.api.ManagerService;
import com.base.cabby.service.impl.ManagerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {

    ApplicationContext ctx = SpringApplication.run(MainApp.class, args);

    ManagerService managerService = (ManagerServiceImpl) ctx.getBean("managerServiceImpl");
    managerService.initialise();
  }

  
}
