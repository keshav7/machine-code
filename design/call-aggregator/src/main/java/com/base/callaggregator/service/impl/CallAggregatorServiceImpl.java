package com.base.callaggregator.service.impl;

import com.base.callaggregator.model.Call;
import com.base.callaggregator.model.CallLog;
import com.base.callaggregator.model.Rank;
import com.base.callaggregator.service.api.CallAggregator;
import com.base.callaggregator.service.api.CallLogService;
import com.base.callaggregator.service.pubsub.RankOneQueueService;
import com.base.callaggregator.service.pubsub.RankThreeQueueService;
import com.base.callaggregator.service.pubsub.RankTwoQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallAggregatorServiceImpl implements CallAggregator {

  // we can also maintain factory for these queues

  @Autowired
  RankOneQueueService rankOneQueueService;

  @Autowired
  RankTwoQueueService rankTwoQueueService;

  @Autowired
  RankThreeQueueService rankThreeQueueService;

  @Autowired
  CallLogService callLogService;

  @Override
  public void escalateCall(Call call, Rank rank) {
    CallLog callLog;
    switch (rank) {
      case ONE:
        callLog = CallLog.builder().callId(call.getId()).message("Escalating from rank" + rank.name()).build();
        callLogService.addCallLog(callLog);
        rankTwoQueueService.addCall(call);
        break;

      case TWO:
        callLog = CallLog.builder().callId(call.getId()).message("Escalating from rank" + rank.name()).build();
        callLogService.addCallLog(callLog);
        rankThreeQueueService.addCall(call);
        break;

      case THREE:
        callLog = CallLog.builder().callId(call.getId()).message("Unable to handle call").build();
        callLogService.addCallLog(callLog);
        System.out.println("call not handled.. retry");
        break;
    }

  }

  @Override
  public void callHandled(Call call, Rank rank) {
    CallLog callLog;
    callLog = CallLog.builder().callId(call.getId()).message("call handled by" + rank.name()).build();
    System.out.println("Call Handled" + rank);
    callLogService.addCallLog(callLog);
  }

}
