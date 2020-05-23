package com.bms.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCinemaSeatRequest {

  String cinemaId;
  String seatName;

}
