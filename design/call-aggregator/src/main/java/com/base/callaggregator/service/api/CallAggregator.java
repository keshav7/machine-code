package com.base.callaggregator.service.api;

import com.base.callaggregator.model.Call;
import com.base.callaggregator.model.Rank;

public interface CallAggregator {

  void escalateCall(Call call, Rank rank);

  void callHandled(Call call, Rank rank);

}