package com.starter.backend.exceptions;

public class ApiRequestException extends RuntimeException{
    public  ApiRequestException(String message){
        super(message);
    }
}
