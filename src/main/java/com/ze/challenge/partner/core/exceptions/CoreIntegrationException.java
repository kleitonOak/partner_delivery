package com.ze.challenge.partner.core.exceptions;

public class CoreIntegrationException extends Exception{

    public CoreIntegrationException(String message){
        super(message);
    }

    public CoreIntegrationException(String message, Throwable throwable){
        super(message, throwable);
    }
}
