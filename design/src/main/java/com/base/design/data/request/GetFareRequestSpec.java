package com.base.design.data.request;

import com.base.design.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFareRequestSpec {

  Location startLocation;
  Location endLocation;
}
