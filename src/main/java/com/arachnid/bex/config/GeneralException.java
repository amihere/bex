package com.arachnid.bex.config;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GeneralException extends ResponseStatusException {
  private Map<String, String> messages = Collections.emptyMap();
  public GeneralException(String detail) {
    super(HttpStatus.BAD_REQUEST, detail);
  }

  public GeneralException(HttpStatus statusCode, String reason, Throwable cause,
                          Map<String, String> messages) {
    super(statusCode, reason, cause);
    this.messages = messages;
  }

  public Map<String, String> getMessages() { return messages; }
}
