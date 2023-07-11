package com.padelapp.model.exception;

public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 7824416863383128610L;

  public ResourceNotFoundException(final String msg) {
    super(msg);
  }

}
