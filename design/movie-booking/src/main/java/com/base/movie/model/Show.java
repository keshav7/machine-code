package com.base.movie.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Show {
  String id;
  String movieId;
  String cinemaId;

}
