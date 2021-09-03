package com.cursoangular.projetoangular.services;

import com.cursoangular.projetoangular.domain.Categoria;
import com.cursoangular.projetoangular.repositories.CategoriaRepository;
import com.cursoangular.projetoangular.services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamException;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo; //Com o autowired, a dependencia vai ser automaticamente instanciada pelo Spring

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id); //Vai buscar o objeto pelo id dele, usamos o Optional porque estamos buscando uma coisa especifica no banco de dados
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); //Essa categoria.class.getName é o nome da classe que esta com erro.
    }

    /*
    Optional: é uma classe que foi implementada no Java 8, que tem o
    objetivo de simplificar os códigos, facilitando a vida dos desenvolvedores.
    O Optional nos ajuda a evitar os erros NullPointerException, tirar a necessidade
    da verificação (if x != null) e também a escrever um código com menos linhas e mais bonito.
    Com ele você só pode pegar o resultado se ele existir e tem que testar de alguma forma
    (há facilitadores), não corre o risco de pegar um resultado inválido.

    orElse: Se um valor estiver presente, retorna o valor, caso contrário, retorna o valor definido no parâmetro. orElseGet -
    Se um valor estiver presente, retorna o valor, caso contrário, retorna o resultado produzido pelo parâmetro.
     */

}
