package com.base.cabby.service.api;

public interface OrchestratorService {

  void assignRequest(String src, String dest, String cabRegNum, String requestId);

  void requestCompleted(String requestId);
}
