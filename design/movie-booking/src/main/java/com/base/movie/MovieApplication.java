package com.base.movie;

import com.base.movie.service.api.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MovieApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(MovieApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    ManagerService managerService = (ManagerService) ctx.getBean("managerServiceImpl");

    managerService.initialise();
    //Arrays.sort(beanNames);
    //
    //for (String beanName : beanNames) {
    //  System.out.println(beanName);
    //}


    List<Integer> cap = new ArrayList<>();
    cap.add(1);
    cap.add(3);
    cap.add(5);
    cap.add(3);
    cap.add(5);
    totalTriplets(cap, 15);
  }


  public static long totalTriplets(List<Integer> capacity, long desiredCapacity) {
    // Write your code here

    long result = 0;
    Map<Integer, List<String>> map = new HashMap<>();
    Set<String> res = new HashSet<>();
    for (int i = 0; i < capacity.size() - 1; i++) {
      String val = i + "," + (i + 1);
      Integer prod = capacity.get(i) * capacity.get(i + 1);
      for(int k = 0 ; k < capacity.size(); k ++) {

        String val1 = val + "," + k;
        char tempArray[] = val1.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);


        val1 = new String(tempArray);
        if ((k != i && k != (i + 1)) && ((capacity.get(k) * prod) == desiredCapacity) &&  !res.contains(val1)) {
          result++;
        }
      }
    }
    return result - 1;

  }









  
}