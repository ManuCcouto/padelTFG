package com.padelapp.model.exception;

public class ForbiddenException extends RuntimeException {

  private static final long serialVersionUID = 7824416863383128610L;

  public ForbiddenException(final String msg) {
    super(msg);
  }
}
