package com.padelapp.model.exception;

public class ResourceFoundException extends RuntimeException {

  private static final long serialVersionUID = 7824416863383128610L;

  public ResourceFoundException(final String msg) {
    super(msg);
  }

}
