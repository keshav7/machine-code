package com.base.ridesharing;

import com.base.ridesharing.data.BookRideSpec;
import com.base.ridesharing.domain.Ride;
import com.base.ridesharing.enums.RideType;
import com.base.ridesharing.service.api.RideService;
import com.base.ridesharing.service.impl.RideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class DesignApplication {

  //@Autowired
  //RideService rideService;


  public static void main(String[] args) {
    //SpringApplication.run(DesignApplication.class, args);

    Ride ride1 = new Ride("u1", "A", "B", 500D, 3000L);
    Ride ride2 = new Ride("u1", "B", "C", 500D, 3000L);
    Ride ride3 = new Ride("u1", "C", "D", 500D, 3000L);
    Ride ride4 = new Ride("u1", "D", "A", 500D, 3000L);
    Ride ride5 = new Ride("u1", "A", "B", 300D, 4000L);


    RideServiceImpl rideService = new RideServiceImpl();
    rideService.AddRide(ride1);
    rideService.AddRide(ride2);
    rideService.AddRide(ride3);
    rideService.AddRide(ride4);
    rideService.AddRide(ride5);

    BookRideSpec bookRideSpec = new BookRideSpec("ux", RideType.EARLIEST, "A", "B");
    Ride ride = rideService.bookRide(bookRideSpec);

    System.out.println("hello");

    



  }

}
