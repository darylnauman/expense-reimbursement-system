package com.ex.requestreimbursement.exceptions;

public class RRNotFoundException extends RuntimeException {

    public RRNotFoundException() {
    }

    public RRNotFoundException(String message) {
        super(message);
    }

    public RRNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RRNotFoundException(Throwable cause) {
        super(cause);
    }

    public RRNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
