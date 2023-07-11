package com.padelapp.exception;

public class AuthenticateException extends RuntimeException {

    private static final long serialVersionUID = 7824416863383128610L;

    public AuthenticateException(final String msg) {
        super(msg);
    }
}