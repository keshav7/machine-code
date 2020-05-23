package com.bms.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookingRequest {

  String showId;
  String userId;
  String cinemaId;
  List<String> seatIds;


}
