package com.ze.challenge.partner.core.exceptions;

public class CoreBusinessException extends Exception{

    public CoreBusinessException(String message){
        super(message);
    }

    public CoreBusinessException(String message, Throwable throwable){
        super(message, throwable);
    }
}
