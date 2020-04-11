package com.base.design.service.api;

import com.base.design.data.request.GetFareRequestSpec;
import com.base.design.data.result.GetFareResponse;

public interface FareService {


  GetFareResponse getFare(GetFareRequestSpec spec);
}
