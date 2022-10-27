package ru.tt.coursspring2.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OversizeException extends RuntimeException{
    public OversizeException(String message) {
        super(message);
    }
}
