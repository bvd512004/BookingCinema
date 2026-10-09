package com.duc.cinebook.exception;

import com.duc.cinebook.exception.ErrorTime;

public class APIException extends RuntimeException {
  public APIException(ErrorTime errorTime) {
    super(errorTime.getMessage());
    this.errorTime = errorTime;
    ;
  }

  public ErrorTime errorTime;

  public ErrorTime getErrorTime() {
    return errorTime;
  }

  public APIException(String message) {
    super(message);
  }
}
