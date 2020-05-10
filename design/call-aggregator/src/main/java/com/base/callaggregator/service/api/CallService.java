package com.base.callaggregator.service.api;

import com.base.callaggregator.model.Call;
import com.base.callaggregator.model.CallStatus;

public interface CallService {

  Call addNewCall(String name);

  Call updateCallStatus(String id, CallStatus callStatus);
}
