package com.arachnid.bex.registration;

import com.arachnid.bex.config.GeneralException;
import com.arachnid.bex.registration.data.SecurityUser;
import com.arachnid.bex.registration.data.SecurityUserRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
  private final SecurityUserRepository securityUserRepository;

  public RegisterService(SecurityUserRepository securityUserRepository) {
    this.securityUserRepository = securityUserRepository;
  }

  public RegistrationResponse registerUser(String username) {
    var unique = this.securityUserRepository.findByUsername(username).isEmpty();
    if (!unique) {
      throw new GeneralException("Non-unique name");
    }

    var token = UUID.randomUUID().toString();
    var newUser = new SecurityUser(-1, username, token);
    this.securityUserRepository.save(newUser);
    return new RegistrationResponse(username, token);
  }
}
