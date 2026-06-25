package com.example.UserApi.exception.exceptionhandler;

/** ResourceNotFoundException. */
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String msj) {
    super(msj);
  }
}
