package com.design.base.snakesandladders;

import com.design.base.snakesandladders.service.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.base.design"})
public class DesignApplication {

  public static void main(String[] args) {
    SpringApplication.run(DesignApplication.class, args);

    ManagerService managerService = new ManagerService();
    managerService.play();

  }

}
                           	