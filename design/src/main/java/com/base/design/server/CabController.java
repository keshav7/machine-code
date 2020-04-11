package com.base.design.server;

import com.base.design.core.exception.BaseException;
import com.base.design.core.response.ClientResponse;
import com.base.design.core.utils.ResourceUtils;
import com.base.design.data.request.AddCabRequestSpec;
import com.base.design.data.request.RequestPojo;
import com.base.design.service.api.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cab")
public class CabController {

  @Autowired
  CabService cabService;

  @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public
  @ResponseBody
  ResponseEntity addCab(@RequestBody @Valid AddCabRequestSpec request) {
    ClientResponse<Object> clientResponse;
    try {
      clientResponse = cabService.addNewCab(request);

    } catch (BaseException e) {
      clientResponse = ResourceUtils.setClientErrorResponse(e);
    }

    return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
  }

}
