package org.kainos.ea.client;

public class FailedToGetOrderException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to get orders from the database";
    }
}
