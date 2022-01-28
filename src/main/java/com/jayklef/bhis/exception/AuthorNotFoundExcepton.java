package com.jayklef.bhis.exception;

public class AuthorNotFoundExcepton extends Exception{
    public AuthorNotFoundExcepton() {
        super();
    }

    public AuthorNotFoundExcepton(String message) {
        super(message);
    }

    public AuthorNotFoundExcepton(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundExcepton(Throwable cause) {
        super(cause);
    }

    protected AuthorNotFoundExcepton(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
