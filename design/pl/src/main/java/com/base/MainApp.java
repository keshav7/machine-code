package com.base;

import com.base.service.impl.Booter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {

    ApplicationContext ctx = SpringApplication.run(MainApp.class, args);


    Booter booter = (Booter) ctx.getBean("booter");
    booter.booter();

  }


}
