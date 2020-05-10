package com.base.callaggregator.service.impl;

import com.base.callaggregator.model.CallLog;
import com.base.callaggregator.service.api.CallLogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CallLogServiceImpl implements CallLogService {

  Map<String, List<CallLog>> callLogMap = new HashMap<>();
  @Override
  public void addCallLog(CallLog callLog) {
    String callId = callLog.getCallId();
    if (!callLogMap.containsKey(callId)) {
         callLogMap.put(callId, new ArrayList<>());
    }
    callLogMap.get(callId).add(callLog);
  }

  @Override
  public List<CallLog> getCallLogs(String callId) {
    return callLogMap.get(callId);
  }
}
