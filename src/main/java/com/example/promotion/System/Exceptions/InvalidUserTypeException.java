package com.example.promotion.System.Exceptions;

public class InvalidUserTypeException extends RuntimeException{
    public InvalidUserTypeException(String message){
        super(message);
    }
}
