package com.PrestamoBancarios.Prestamo.exeption;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
