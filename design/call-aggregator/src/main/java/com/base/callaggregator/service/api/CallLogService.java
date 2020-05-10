package com.base.callaggregator.service.api;

import com.base.callaggregator.model.CallLog;

import java.util.List;

public interface CallLogService {

  void addCallLog(CallLog callLog);

  List<CallLog> getCallLogs(String callId);
}
