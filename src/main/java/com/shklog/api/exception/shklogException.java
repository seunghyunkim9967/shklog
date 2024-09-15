package com.shklog.api.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class shklogException extends RuntimeException {

    public final Map<String, String> validation = new HashMap<>();

    public shklogException(String message) {
        super(message);
    }

    public shklogException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String FieldName, String message) {
        validation.put(FieldName, message);
    }
}
