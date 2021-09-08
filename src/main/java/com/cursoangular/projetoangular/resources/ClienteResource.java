package com.cursoangular.projetoangular.resources;

import com.cursoangular.projetoangular.domain.Categoria;
import com.cursoangular.projetoangular.domain.Cliente;
import com.cursoangular.projetoangular.services.CategoriaService;
import com.cursoangular.projetoangular.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes") //A classe vai responder por esse end-point
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET) //Esse id é um apelido que eu escolho, pode ser qualquer nome
    public ResponseEntity<?> findById(@PathVariable Integer id) { //Essa notação serve para mim conseguir usar uma variável e injetar o valor do id no id que esta mapeado na utl
        //O objeto responseEntity é um tipo especial do Spring  que encapsula
        //armazena varias informações de uma reposta http para um serviço rest. O ponto de interrogação serve para que qualquer tipo seja usado

        Cliente cliente = clienteService.buscar(id);
        return ResponseEntity.ok().body(cliente);
        /* Para saber se a resposta ocorreu tudo bem, usamos o ResponseEntity.ok().body(obj)
        nesse a requisição tem como corpo o objeto que eu coloquei para ele me trazer
         */
    }
    //Em vez de usar try catch, nos vamos usar um handler, que vai interceptar o erro e nos retornar o status 404 com o nome do erro que houve (Exceção que houve)


}