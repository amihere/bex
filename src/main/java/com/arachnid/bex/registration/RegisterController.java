package com.arachnid.bex.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/register")
public class RegisterController {
  private final RegisterService registerService;

  public RegisterController(RegisterService registerService) {
    this.registerService = registerService;
  }

  @PostMapping
  public RegistrationResponse registerUser(String username) {
    return registerService.registerUser(username);
  }
}
