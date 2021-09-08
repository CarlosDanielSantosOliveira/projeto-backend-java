package com.cursoangular.projetoangular.repositories;

import com.cursoangular.projetoangular.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRespository extends JpaRepository<Endereco, Integer> {
}
