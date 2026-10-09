package  com.duc.cinebook.exception;

import org.springframework.http.HttpStatus;

public enum ErrorTime {
  INVALID_YEAR_OLDS(1006, "Years old must greater than {min}!", HttpStatus.BAD_REQUEST),
  ERROR_NOTDEFINE(1002, "NotFound", HttpStatus.BAD_REQUEST),
  ERROR_CODE(1001, "Existed!", HttpStatus.BAD_REQUEST),
  ERROR_NOTEXISTED(1003, "Not Existed!", HttpStatus.BAD_REQUEST),
  ERROR_LOGIN_FAILED(
      1004, "Login Failed! Please check your email and password!", HttpStatus.BAD_REQUEST),
  ERROR_AUTHOR(1005, "Do not access", HttpStatus.BAD_REQUEST),
  ERROR_CREATE_PASSWORD_FAILED(
      1006, "Create Password Failed! Must be greater than 8 character!", HttpStatus.UNAUTHORIZED),
  ERROR_CREATE_EMAIL_FAILED(1007, "Create Email Failed! Email has existed!", HttpStatus.UNAUTHORIZED),
  ;

  ErrorTime(int code, String message, HttpStatus errorStatus) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  private int code;
  private String message;
}
