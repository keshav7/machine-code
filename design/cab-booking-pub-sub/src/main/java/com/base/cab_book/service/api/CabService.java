package com.base.cab_book.service.api;

import com.base.cab_book.model.Cab;
import com.base.cab_book.model.CabType;

public interface CabService {

  Cab getCab(CabType type);

  Cab addCab(Cab cab);

}
