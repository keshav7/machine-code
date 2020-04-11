package com.base.design.server;

import com.base.design.core.response.ClientResponse;
import com.base.design.data.request.RequestPojo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/trip")
public class TripController {

  //@Autowired
  //ServiceInterface serviceInterface;

  @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public
  @ResponseBody
  ResponseEntity createContainer(@RequestBody @Valid RequestPojo request) {
    ClientResponse<Object> clientResponse = new ClientResponse<>();
    //try {
    //
    //} catch (BaseException e) {
    //  clientResponse = ResourceUtils.setClientErrorResponse(e);
    //}

    return new ResponseEntity<>(clientResponse, clientResponse.getHttpStatus());
  }

}
