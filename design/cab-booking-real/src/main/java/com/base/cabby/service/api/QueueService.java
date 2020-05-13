package com.base.cabby.service.api;

import com.base.cabby.model.CabRequest;

public interface QueueService {
  void addNewRequest(CabRequest request);

  CabRequest fetchRequest();
}
