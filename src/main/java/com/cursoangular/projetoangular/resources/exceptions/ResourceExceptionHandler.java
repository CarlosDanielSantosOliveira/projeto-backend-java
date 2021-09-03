package com.cursoangular.projetoangular.resources.exceptions;

import com.cursoangular.projetoangular.services.Exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@ControllerAdvice
public class ResourceExceptionHandler {
    //Essa classe auxiliar vai interceptar as Exceções

    //Essa função possui a assinatura padrao
    @ExceptionHandler(ObjectNotFoundException.class) //para indicar que essa função é um tratador de erro desse tipo de classe/Exceção.
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    //Essa função vai retornar no corpo da minha requisição detalhes sobre a exceção que ocorreu.

}
