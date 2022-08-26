package com.example.Springboot.demo.error;

public class FieldEmptyException extends Exception{
    public FieldEmptyException() {
        super();
    }

    public FieldEmptyException(String message) {
        super(message);
    }

    public FieldEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldEmptyException(Throwable cause) {
        super(cause);
    }

    protected FieldEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
