package com.quan.exceptionHandling;

public class DatabaseReadEXception extends RuntimeException {
    public DatabaseReadEXception(String message) {
        super(message);

    }
}
