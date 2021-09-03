package com.cursoangular.projetoangular.services.Exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        //è uma exceção que vai me trazer a causa de algo que aconteceu antes.
        super(msg, cause);
    }

}
