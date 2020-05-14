package com.base.timeline.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {

  String id;
  String text;
  String userId;
}
