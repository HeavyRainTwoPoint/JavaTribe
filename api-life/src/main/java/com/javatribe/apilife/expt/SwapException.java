package com.javatribe.apilife.expt;

public class SwapException extends RuntimeException{
    public SwapException() {
    }

    public SwapException(String message) {
        super(message);
    }

    public SwapException(String message, Throwable cause) {
        super(message, cause);
    }

    public SwapException(Throwable cause) {
        super(cause);
    }

    public SwapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
