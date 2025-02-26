package com.arachnid.bex.registration;

import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/register")
public class Controller {

  @PostMapping
  public RegistrationResponse registerUser(String username) {
    return new RegistrationResponse(username, UUID.randomUUID().toString());
  }
}
