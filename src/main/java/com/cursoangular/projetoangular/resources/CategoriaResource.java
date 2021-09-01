package com.cursoangular.projetoangular.resources;

//Resources: nome padrao de onde gravamos nossas classes controladoras rest (recursos)

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias") //A classe vai responder por esse end-point
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public String listar() {
        return "Rest esta funcionando";
    }

}
