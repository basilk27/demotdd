package com.mbsystems.demotdd.exceptions;

public class TTException extends RuntimeException {

    public TTException( String message ) {
        super( message );
    }

    public TTException( String message, Throwable cause ) {
        super( message, cause );
    }

    public TTException( Throwable cause ) {
        super( cause );
    }
}
