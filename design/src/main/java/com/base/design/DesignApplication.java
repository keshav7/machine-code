package com.base.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.base.design"})
public class DesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignApplication.class, args);
	}

}
