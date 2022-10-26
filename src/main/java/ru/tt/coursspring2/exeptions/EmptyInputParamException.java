package ru.tt.coursspring2.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
public class EmptyInputParamException extends RuntimeException{
    public EmptyInputParamException(String message) {
        super(message);
    }
}
