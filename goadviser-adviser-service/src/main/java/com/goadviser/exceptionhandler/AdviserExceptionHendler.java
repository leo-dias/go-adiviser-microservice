package com.goadviser.exceptionhandler;

import com.goadviser.repositories.exceptions.AdviserNotFoudException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviserExceptionHendler {

    @ExceptionHandler({com.mongodb.DuplicateKeyException.class})
    public ResponseEntity<Erro> duplicateKeyException(com.mongodb.DuplicateKeyException e) {
        final String message = e.getMessage();
        return new ResponseEntity<>(new Erro(message), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({AdviserNotFoudException.class})
    public ResponseEntity<Erro> adviserNotFoudException(AdviserNotFoudException e) {
        final String message = e.getMessage();
        return new ResponseEntity<>(new Erro(message), HttpStatus.BAD_REQUEST);
    }


    @Getter
    private static class Erro {
        private String message;

        private Erro(String message) {
            this.message = message;
        }
    }
}
