package com.base.cab_booking.service.api;


import com.base.cab_booking.data.request.AddCabRequestSpec;
import com.base.cab_booking.domain.Cab;
import com.base.cab_booking.enums.CabType;
import com.base.cab_booking.core.exception.BaseException;
import com.base.cab_booking.core.response.ClientResponse;

import java.util.List;

public interface CabService {

  ClientResponse addNewCab(AddCabRequestSpec spec) throws BaseException;
  List<Cab> searchCabs(CabType cabType);
}
