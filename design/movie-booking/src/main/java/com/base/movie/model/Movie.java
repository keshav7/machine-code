package com.base.movie.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {

  String id;
  String name;
}
