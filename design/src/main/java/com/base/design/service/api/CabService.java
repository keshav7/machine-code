package com.base.design.service.api;

import com.base.design.core.exception.BaseException;
import com.base.design.core.response.ClientResponse;
import com.base.design.data.request.AddCabRequestSpec;
import com.base.design.domain.Cab;
import com.base.design.enums.CabType;

import java.util.List;

public interface CabService {

  ClientResponse addNewCab(AddCabRequestSpec spec) throws BaseException;
  List<Cab> searchCabs(CabType cabType);
}
