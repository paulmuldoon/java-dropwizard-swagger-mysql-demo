package org.kainos.ea.client;

public class InvalidProductException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid Product";
    }
}
