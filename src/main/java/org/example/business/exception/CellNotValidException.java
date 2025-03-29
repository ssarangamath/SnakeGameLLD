package org.example.business.exception;

public class CellNotValidException extends RuntimeException{
    public CellNotValidException(String msg){
        super(msg);
    }
}
