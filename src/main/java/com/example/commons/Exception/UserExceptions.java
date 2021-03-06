package com.example.commons.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserExceptions {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public static class RestException extends RuntimeException {
        public RestException() {
        }

        public RestException(String message) {
            super(message);
        }
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public class InternalServerError extends RuntimeException {
        public InternalServerError() {
        }

        public InternalServerError(String message) {
            super(message);
        }
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public static class Forbidden extends RuntimeException {
        public  Forbidden() {}

        public Forbidden(String message) {
            super(message);
        }
    }
}
