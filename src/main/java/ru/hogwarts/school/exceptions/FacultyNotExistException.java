package ru.hogwarts.school.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FacultyNotExistException extends RuntimeException {
    public FacultyNotExistException() {
    }

    public FacultyNotExistException(String message) {
        super(message);
    }

    public FacultyNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacultyNotExistException(Throwable cause) {
        super(cause);
    }

    public FacultyNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
