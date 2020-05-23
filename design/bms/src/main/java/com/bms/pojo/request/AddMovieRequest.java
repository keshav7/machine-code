package com.bms.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
  String name;
  String cityId;
  // add other metadata like
  // star cast, genre etc.
}
