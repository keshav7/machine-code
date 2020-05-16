package com.base.service.impl;

import com.base.service.api.RateCardService;
import org.springframework.stereotype.Service;

@Service
public class RateCardServiceImpl implements RateCardService {

  @Override
  public Double getAmount(Long deltaTime) {

    Long timeInMins = deltaTime/(1000* 60);

    if (timeInMins < 30) {
      return 15D;
    } else if(timeInMins < 60) {
      return 25D;
    } else {
      return 40D;
    }


  }
}
