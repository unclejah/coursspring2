package ru.tt.coursspring2.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExeptionOverSize extends RuntimeException{
    public ExeptionOverSize(String message) {
        super(message);
    }
}
