package com.base.design.service.impl;

import com.base.design.core.enums.Errors;
import com.base.design.core.enums.SuccessCodes;
import com.base.design.core.exception.BaseException;
import com.base.design.core.response.ClientResponse;
import com.base.design.data.request.AddCabRequestSpec;
import com.base.design.domain.Cab;
import com.base.design.enums.CabType;
import com.base.design.service.api.CabService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabServiceImpl implements CabService {

  List<Cab> availablleCabsList = new ArrayList<>();
  List<Cab> bookedCabs = new ArrayList<>();


  @Override
  public ClientResponse addNewCab(AddCabRequestSpec spec) throws BaseException {
    try {
      Cab cab = Cab.builder()
          .regNumber(spec.getRegNumber())
          .type(spec.getType()).build();

      cab.setCreatedAt(System.currentTimeMillis());
      cab.setCreatedBy(spec.getCreatedBy());

      availablleCabsList.add(cab);

      return new ClientResponse(SuccessCodes.CREATED, cab);
    } catch(Exception e) {
      throw new BaseException(Errors.BS_INTERNAL_ERROR);
    }
  }

  @Override
  public List<Cab> searchCabs(CabType cabType) {
    return null;  // TODO impl
  }
}
