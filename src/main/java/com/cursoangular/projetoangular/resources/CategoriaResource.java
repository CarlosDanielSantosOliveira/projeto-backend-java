package com.cursoangular.projetoangular.resources;

//Resources: nome padrao de onde gravamos nossas classes controladoras rest (recursos)

import com.cursoangular.projetoangular.domain.Categoria;
import com.cursoangular.projetoangular.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias") //A classe vai responder por esse end-point
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET) //Esse id é um apelido que eu escolho, pode ser qualquer nome
    public ResponseEntity<?> findById(@PathVariable Integer id) { //Essa notação serve para mim conseguir usar uma variável e injetar o valor do id no id que esta mapeado na utl
    //O objeto responseEntity é um tipo especial do Spring  que encapsula
        //armazena varias informações de uma reposta http para um serviço rest. O ponto de interrogação serve para que qualquer tipo seja usado

        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
        /* Para saber se a resposta ocorreu tudo bem, usamos o ResponseEntity.ok().body(obj)
        nesse a requisição tem como corpo o objeto que eu coloquei para ele me trazer
         */
    }



}
