package com.portfolio.portfoliokevincastillo.entities.exception;

public class EmailException extends RuntimeException{
    public EmailException(String message) {
        super("Error de envio de correo: \n" + message);
    }
}
