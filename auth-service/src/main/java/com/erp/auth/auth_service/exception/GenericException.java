package com.erp.auth.auth_service.exception;

public class GenericException extends RuntimeException {
    private int statusCode;
    public GenericException(int statusCode,String msg)
    {
        super(msg);
        this.statusCode=statusCode;
    }
    public int getStatusCode()
 {
   return this.statusCode;
}
}
