package com.cursoangular.projetoangular.services;

import com.cursoangular.projetoangular.domain.Categoria;
import com.cursoangular.projetoangular.domain.Cliente;
import com.cursoangular.projetoangular.repositories.ClienteRepository;
import com.cursoangular.projetoangular.services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id); //Vai buscar o objeto pelo id dele, usamos o Optional porque estamos buscando uma coisa especifica no banco de dados
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); //Essa categoria.class.getName é o nome da classe que esta com erro.
    }

}
