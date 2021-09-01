package com.cursoangular.projetoangular.resources;

//Resources: nome padrao de onde gravamos nossas classes controladoras rest (recursos)

import com.cursoangular.projetoangular.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias") //A classe vai responder por esse end-point
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar() {

        Categoria cat1 = new Categoria(1, "Informática");
        Categoria cat2 = new Categoria(2, "Escritório");

        List<Categoria> lista =new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }

}
