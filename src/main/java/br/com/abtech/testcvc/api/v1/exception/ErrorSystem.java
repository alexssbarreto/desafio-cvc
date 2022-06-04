package br.com.abtech.testcvc.api.v1.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorSystem extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ErrorSystem(String msg) {
        super(msg);
    }

    public ErrorSystem(String msg, Throwable cause) {
        super(msg, cause);
    }

    public static Map<String, String> error(String attribute, String message) {
        Map<String, String> error = new HashMap<>();
        error.put(attribute, message);

        return error;
    }
}
