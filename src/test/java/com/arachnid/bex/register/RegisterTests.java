package com.arachnid.bex.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.arachnid.bex.config.GeneralException;
import com.arachnid.bex.registration.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegisterTests {

  @Autowired private RegisterService service;

  @Test
  public void testRegister() {
    var response = service.registerUser("lewis");
    assertNotNull(response);
    assertEquals(response.username(), "lewis");
  }

  @Test
  public void testFailedRegister() {
    var response = service.registerUser("lewis");
    assertNotNull(response);
    assertEquals(response.username(), "lewis");

    assertThrows(GeneralException.class, () -> service.registerUser("lewis"));
  }
}
