package com.ocr.john.omood.model.exception;

/**
 * Created by bob on 15/12/17.
 */

public class InvalidDataException extends Exception {


    private static final long serialVersionUID = 1933180583148907879L;

    public InvalidDataException(){
        System.out.println("Stored data not valid");
    }

    public InvalidDataException(String msg){
        super(msg);
    }
}
