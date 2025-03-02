package com.arachnid.bex.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
  private static final Logger log =
      LogManager.getLogger(ExceptionHandler.class);
  // write

  @Override
  protected ResponseEntity<Object>
  handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                          HttpStatusCode status, WebRequest request) {
    if (ex instanceof GeneralException) {
      log.error(ex);
      return super.handleExceptionInternal(ex, body, headers, status, request);
    }
    return super.handleExceptionInternal(ex, body, headers, status, request);
  }
}
