package com.base.timeline;

import com.base.timeline.service.impl.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(MainApp.class, args);
    ManagerService managerService = (ManagerService) ctx.getBean("managerService");

    managerService.initialise();
  }
}
