package com.erp.user_service.exception;

public class IncompleteData extends RuntimeException {
    public IncompleteData(String message) {
        super(message);
    }
}
