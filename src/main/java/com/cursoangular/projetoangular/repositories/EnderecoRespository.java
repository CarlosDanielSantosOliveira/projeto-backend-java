package com.cursoangular.projetoangular.repositories;

import com.cursoangular.projetoangular.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRespository extends JpaRepository<Endereco, Integer> {
}
