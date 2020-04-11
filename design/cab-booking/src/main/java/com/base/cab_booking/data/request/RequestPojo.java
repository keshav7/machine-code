package com.base.cab_booking.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestPojo {


  @Nullable
  private List<Integer> input;

  @Nullable
  private String inputstr;

  @Nullable
  private Integer inputint;

  @Nullable
  private Integer inputsecondint;

  @Nullable
  private ArrayList<ArrayList<Integer>> twodlist;

}
