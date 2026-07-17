package br.com.dio.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(final String m){
        super(m);
    }
}
