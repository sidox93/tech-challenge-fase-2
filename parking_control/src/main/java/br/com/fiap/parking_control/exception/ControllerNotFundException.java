package br.com.fiap.parking_control.exception;

public class ControllerNotFundException extends RuntimeException{
    public ControllerNotFundException(String message){
        super(message);
    }
}
