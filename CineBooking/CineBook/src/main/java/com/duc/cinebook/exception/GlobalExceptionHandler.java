package com.duc.cinebook.exception;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.duc.cinebook.dto.response.APIResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  ResponseEntity<APIResponse> handlingRuntimeException(RuntimeException exception) {
    APIResponse resp = new APIResponse();
    resp.setMessage(ErrorTime.ERROR_NOTDEFINE.getMessage());
    resp.setCode(ErrorTime.ERROR_NOTDEFINE.getCode());
    return ResponseEntity.badRequest().body(resp);
  }

  @ExceptionHandler(value = APIException.class)
  ResponseEntity<APIResponse> handlinAPIException(APIException exception) {
    ErrorTime errorTime = exception.getErrorTime();
    APIResponse resp = new APIResponse();
    resp.setMessage(errorTime.getMessage());
    resp.setCode(errorTime.getCode());
    return ResponseEntity.badRequest().body(resp);
  }

  @ExceptionHandler(value = ConstraintViolationException.class)
  public ResponseEntity<APIResponse> handleConstraintViolationException(
      ConstraintViolationException exception) {
    String message = exception.getConstraintViolations().iterator().next().getMessage();
    String[] parts = message.split(":");
    String enumKey = parts[0];
    String minValue = parts.length > 1 ? parts[1] : "";
    ErrorTime errorcode = ErrorTime.INVALID_YEAR_OLDS;
    //        try {
    //            errorcode = ErrorTime.valueOf(enumKey);
    //        } catch (IllegalArgumentException e) {
    //
    //        }
    APIResponse resp = new APIResponse();
    resp.setCode(errorcode.getCode());
    resp.setMessage(errorcode.getMessage().replace("{min}", minValue));
    return ResponseEntity.badRequest().body(resp);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<APIResponse> handleMethodArgumentNotValid(
      MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();
    String message =
        exception.getBindingResult().getAllErrors().iterator().next().getDefaultMessage();

    exception
        .getBindingResult()
        .getAllErrors()
        .forEach(
            error -> {
              if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
              } else {
                String objectName = error.getObjectName();
                String errorMessage = error.getDefaultMessage();
                errors.put(objectName, errorMessage);
              }
            });
    APIResponse<Map<String, String>> response = new APIResponse<>();
    response.setCode(HttpStatus.BAD_REQUEST.value());
    response.setMessage(message);
    return ResponseEntity.badRequest().body(response);
  }
}
