package org.example.exceptions;

public class ValidationException extends RuntimeException{

    String message;
    public ValidationException(String message){
        super(message);
        this.message = message;
    }
}
